import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + "," + name + "," + age;
    }
}

public class Problem5 {

    public static void main(String[] args) {

        HashMap<Integer, Student> studentMap = new HashMap<>();
        List<String> invalidList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                try {
                    String[] arr = line.split(",");

                    if (arr.length != 3) {
                        throw new Exception("Wrong format");
                    }

                    int id = Integer.parseInt(arr[0].trim());
                    String name = arr[1].trim().replaceAll("\\s+", " ");
                    int age = Integer.parseInt(arr[2].trim());

                    if (age < 18) {
                        throw new Exception("Age below 18");
                    }

                    if (studentMap.containsKey(id)) {
                        throw new Exception("Duplicate ID");
                    }

                    studentMap.put(id, new Student(id, name, age));

                } catch (Exception e) {
                    invalidList.add(line);
                }
            }

            writeValid("valid.txt", studentMap.values());
            writeInvalid("invalid.txt", invalidList);

        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    static void writeValid(String file, Collection<Student> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }

    static void writeInvalid(String file, List<String> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
}
