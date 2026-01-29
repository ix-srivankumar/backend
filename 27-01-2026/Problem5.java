import java.io.*;
import java.util.*;
import java.util.logging.*;

class InvalidStudentException extends Exception {
    public InvalidStudentException(String msg) {
        super(msg);
    }
}

class Student {
    Integer id;
    String name;
    Integer age;

    Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id.equals(s.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }
}

public class Problem5 {

    private static final Logger logger = Logger.getLogger("StudentLog");

    public static void main(String[] args) {

        setupLogger();

        List<Student> validList = new ArrayList<>();
        Set<Student> uniqueSet = new HashSet<>();
        List<String> invalidList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    Student s = parseStudent(line);
                    if (!uniqueSet.add(s)) {
                        throw new InvalidStudentException("Duplicate student");
                    }
                    validList.add(s);
                } catch (Exception e) {
                    invalidList.add(line);
                    logger.warning("Invalid: " + line + " | " + e.getMessage());
                }
            }

            writeFile("valid.txt", validList);
            writeFile("invalid.txt", invalidList);

            logger.info("File processing completed");

        } catch (IOException e) {
            logger.severe("File read error: " + e.getMessage());
        }
    }

    private static Student parseStudent(String line) throws InvalidStudentException {

        String[] arr = line.split(",");

        if (arr.length != 3) {
            throw new InvalidStudentException("Wrong format");
        }

        try {
            Integer id = Integer.valueOf(arr[0].trim());
            String name = cleanName(arr[1]);
            Integer age = Integer.valueOf(arr[2].trim());

            if (age < 18) {
                throw new InvalidStudentException("Age below 18");
            }

            return new Student(id, name, age);

        } catch (NumberFormatException e) {
            throw new InvalidStudentException("Invalid number");
        }
    }

    private static String cleanName(String name) {
        return new StringBuilder(name.trim().replaceAll("\\s+", " ")).toString();
    }

    private static void writeFile(String file, List<?> data) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Object o : data) {
            bw.write(o.toString());
            bw.newLine();
        }
        bw.close();
    }

    private static void setupLogger() {
        try {
            FileHandler fh = new FileHandler("app.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (IOException ignored) {}
    }
}
