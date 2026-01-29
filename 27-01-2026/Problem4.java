import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Number> list = new ArrayList<>();
        List<String> invalidInputs = new ArrayList<>();

        System.out.println("Enter values : ");
        String line = sc.nextLine();

        String[] inputs = line.split("\\s+");

        for (String input : inputs) {
            try {
                if (input.contains(".")) {
                    Double d = Double.valueOf(input);
                    list.add(d);
                } else {
                    Integer i = Integer.valueOf(input);
                    list.add(i);
                }
            } catch (NumberFormatException e) {
                invalidInputs.add(input);
            }
        }

        int intSum = 0;
        double floatSum = 0.0;
        int floatCount = 0;

        for (Number num : list) {
            if (num instanceof Integer) {
                intSum += num.intValue();
            }
        }

        Iterator<Number> it = list.iterator();
        while (it.hasNext()) {
            Number num = it.next();
            if (num instanceof Double) {
                floatSum += num.doubleValue();
                floatCount++;
            }
        }

        System.out.println("Sum of integers: " + intSum);

        if (floatCount > 0) {
            System.out.println("Average of floating numbers: " + (floatSum / floatCount));
        } else {
            System.out.println("No floating numbers");
        }

        if (!invalidInputs.isEmpty()) {
            System.out.println("Invalid inputs:");
            for (String s : invalidInputs) {
                System.out.println(s);
            }
        }

        sc.close();
    }
}
