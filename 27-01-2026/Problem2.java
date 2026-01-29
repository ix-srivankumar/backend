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
    
    // Step 1: Convert array to ArrayList
    private static ArrayList<String> convertArrayToArrayList(String[] array) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Original array size: " + array.length);
        System.out.println("ArrayList size (with duplicates): " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("   [" + i + "] " + list.get(i));
        }
        return list;
    }
    
    // Step 2: Remove duplicates using HashSet
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
        
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   " + entry.getKey() + " : " + entry.getValue());
        }
        return frequencyMap;
    }
    
    private static void displayDataWithIterationTechniques(
            HashSet<String> uniqueSet,
            HashMap<String, Integer> frequencyMap,
            ArrayList<String> list) {
        int count = 1;
        for (String employee : uniqueSet) {
            System.out.println("   " + count + ". " + employee);
            count++;
        }
        Iterator<String> setIterator = uniqueSet.iterator();
        count = 1;
        while (setIterator.hasNext()) {
            System.out.println("   " + count + ". " + setIterator.next());
            count++;
        }
        
        // Technique 3: Stream API with forEach
        count = 1;
        for (String employee : list) {
            System.out.println("   " + count + ". " + employee);
            count++;
        }
        
        // Technique 4: Iterator on ArrayList
        System.out.println("\nTechnique 4: Iterator on ArrayList");
        System.out.println("All Employees (using Iterator):");
        Iterator<String> listIterator = list.iterator();
        count = 1;
        while (listIterator.hasNext()) {
            System.out.println("   " + count + ". " + listIterator.next());
            count++;
        }
        
        // Technique 5: EntrySet iteration on HashMap
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue() + " occurrence(s)");
        }
        
        // Technique 6: Iterator on HashMap entrySet
        Iterator<Map.Entry<String, Integer>> mapIterator = frequencyMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> entry = mapIterator.next();
            System.out.println("   " + entry.getKey() + " -> " + entry.getValue());
        }
        
        // Technique 7: values() iteration
        int index = 1;
        for (Integer frequency : frequencyMap.values()) {
            System.out.println("   Frequency " + index + ": " + frequency);
            index++;
        }
        
        // Technique 8: keySet() iteration
        index = 1;
        for (String name : frequencyMap.keySet()) {
            System.out.println("   " + index + ". " + name);
            index++;
        }
    }
}
