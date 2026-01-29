import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Problem3 {
    private static FileWriter logWriter;

    public static void main(String[] args) {
        initializeLogging();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            validateUser(username, age, email);
            System.out.println("User validation successful");
            logValidationCompletion("Validation completed successfully for user: " + username);

        } catch (InvalidUsernameException | InvalidAgeException | InvalidEmailException e) {
            handleValidationError("Checked Exception", e);
        } catch (ValidationException e) {
            handleValidationError("Unchecked Exception", e);
        } finally {
            closeLogging();
            sc.close();
            System.out.println("Logging closed");
        }
    }

    private static void validateUser(String username, int age, String email)
            throws InvalidUsernameException, InvalidAgeException, InvalidEmailException {

        if (username == null || email == null) {
            throw new ValidationException("Null value not allowed");
        }

        if (username.length() < 3) {
            throw new InvalidUsernameException("Username must be at least 3 characters");
        }

        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60");
        }

        if (!email.matches("^(!?.*\\..\\.)[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new InvalidEmailException("Invalid email format");
}

    }

    private static void initializeLogging() {
        try {
            logWriter = new FileWriter("validation_log.txt", true);
        } catch (IOException e) {
            throw new RuntimeException("Unable to initialize logging");
        }
    }

    private static void handleValidationError(String type, Exception e) {
        System.out.println(type + ": " + e.getMessage());
        try {
            logWriter.write(type + ": " + e.getMessage() + "\n");
        } catch (IOException ignored) {
        }
    }

    private static void logValidationCompletion(String message) {
        try {
            logWriter.write(message + "\n");
        } catch (IOException ignored) {
        }
    }

    private static void closeLogging() {
        try {
            if (logWriter != null) {
                logWriter.close();
            }
        } catch (IOException ignored) {
        }
    }
}
