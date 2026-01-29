import java.io.*;
import java.util.*;

public class Problem1 {
    
    public static void main(String[] args) {
        
        String filePath = "paragraph.txt";
        StringBuilder content = new StringBuilder();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            String paragraph = content.toString();
            countAnalysis(paragraph);
            String cleanedParagraph = paragraph.replaceAll("\\s+", " ").trim();
            System.out.println("\nAfter removing multiple spaces:\n" + cleanedParagraph+"\n\n");
            findTopFrequentWords(cleanedParagraph, 5);
            reverseSentences(cleanedParagraph);
            compareStrings();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Method to count words, sentences, and characters
    private static void countAnalysis(String paragraph) {
        String[] words = paragraph.trim().split("\\s+");
        int wordCount = words.length;
        String[] sentences = paragraph.split("[.!?]+");
        int sentenceCount = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                sentenceCount++;
            }
        }
        int charCount = paragraph.replaceAll("\\s", "").length();
        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Sentences: " + sentenceCount);
        System.out.println("Total Characters (excluding spaces): " + charCount);
    }
    
    // Method to find top 5 most frequent words
    private static void findTopFrequentWords(String paragraph, int topN) {
        String[] words = paragraph.toLowerCase().split("[^a-z0-9]+");
        
        // Create HashMap for frequency count
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        
        // Sort by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFrequency.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        System.out.println("TOP " + topN + " MOST FREQUENT WORDS:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedWords) {
            if (count >= topN) break;
            System.out.println((count + 1) + ". \"" + entry.getKey() + "\" - " + entry.getValue() + " times");
            count++;
        }
    }
    
    // Method to reverse each sentence without changing word order
    private static void reverseSentences(String paragraph) {
        String[] sentences = paragraph.split("[.!?]+");
        StringBuilder reversed_paragraph = new StringBuilder();
        System.out.println("\nReversed Sentences:  ");
        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                String[] words = sentence.split("\\s+");
                StringBuilder reversed = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    if (reversed.length() > 0) {
                        reversed.append(" ");
                    }
                    reversed.append(words[i]);
                }
                reversed_paragraph.append(reversed.toString()).append(". ");
            }
        }
            System.out.println("Reversed: " + reversed_paragraph.toString());
            System.out.println();
        
    }

    private static void compareStrings() {
        
        String str1 = new String("sand");
        String str2 = new String("sand");
        String str3= "sand";
        String str4 = "sand";
        
        System.out.println("Using ==   : ");
        System.out.println("str1 == str2: " + (str1 == str2) + " (Different objects)");
        System.out.println("str3 == str4: " + (str3 == str4) + " (String interning in literal pool)");
        System.out.println();
        
        System.out.println("Using equals() :");
        System.out.println("str1.equals(str2): " + str1.equals(str2) + " (Same content)");
        System.out.println("str3.equals(str4): " + str3.equals(str4) + " (Same content)");
        
    }
}
