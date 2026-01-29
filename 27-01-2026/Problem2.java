import java.util.*;

public class Problem2 {
    
    public static void main(String[] args) {
        String[] employeeArray = {
            "nani reddy","sathwik thotapelli","harsha vardhan","sai charan",
            "nikhil","prashant","srinu","nani reddy","srinu","bablu","nikhil"
        };
        
        ArrayList<String> employeeList = convertArrayToArrayList(employeeArray);
        
        HashSet<String> uniqueEmployees = removeDuplicates(employeeList);
        
        HashMap<String, Integer> frequencyMap = createFrequencyMap(employeeList);

        displayDataWithIterationTechniques(uniqueEmployees, frequencyMap, employeeList);
    }

    private static ArrayList<String> convertArrayToArrayList(String[] array) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Original array size: " + array.length);
        System.out.println("ArrayList size (with duplicates): " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("   [" + i + "] " + list.get(i));
        }
        return list;
    }
    
    private static HashSet<String> removeDuplicates(ArrayList<String> list) {
        HashSet<String> uniqueSet = new HashSet<>(list);
        System.out.println("Duplicates removed: " + (list.size() - uniqueSet.size()));
        System.out.println("Unique employees count: " + uniqueSet.size());
        int index = 1;
        for (String employee : uniqueSet) {
            System.out.println("   " + index + ". " + employee);
            index++;
        }
        return uniqueSet;
    }
    
    private static HashMap<String, Integer> createFrequencyMap(ArrayList<String> list) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        
        for (String employee : list) {
            frequencyMap.put(employee, frequencyMap.getOrDefault(employee, 0) + 1);
        }
        
        System.out.println(frequencyMap);
        return frequencyMap;
    }

    private static void displayDataWithIterationTechniques(
            HashSet<String> uniqueSet,
            HashMap<String, Integer> frequencyMap,
            ArrayList<String> list) {
        int count = 1;
        for (String employee : list) {
            System.out.println("   " + count + ". " + employee);
            count++;
        }
        Iterator<String> listIterator = list.iterator();
        count = 1;
        while (listIterator.hasNext()) {
            System.out.println("   " + count + ". " + listIterator.next());
            count++;
        }
    }
}
