import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Double> valid = new ArrayList<>();
        List<String> invalid = new ArrayList<>();
        System.out.print("Enter numbers : ");

        String[] inputs = sc.nextLine().split("\\s+");

        for (String in : inputs) {
            try {
                if (in.matches("[-+]?(\\d*\\.\\d+|\\d+\\.\\d*|\\d+)([eE][-+]?\\d+)?")) {
                    valid.add(Double.parseDouble(in));
                } else {
                    invalid.add(in);
                }
            } catch (Exception e) {
                invalid.add(in);
            }
        }

        double sum = 0;
        for (double v : valid) {
            System.out.println(v);
            sum += v;
        }

        if (!valid.isEmpty()) {
            System.out.println("Average: " + (sum / valid.size()));
        }

        if (!invalid.isEmpty()) {
            System.out.println("Invalid inputs:");
            for (String s : invalid) {
                System.out.println(s);
            }
        }

        sc.close();
    }
}
