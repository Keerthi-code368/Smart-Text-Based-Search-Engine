import java.io.*;
import java.util.*;

public class SearchEngine {

    // Inverted index: word -> (document -> frequency)
    private static Map<String, Map<String, Integer>> invertedIndex = new HashMap<>();

    // Stop words to ignore
    private static Set<String> stopWords = new HashSet<>(
            Arrays.asList("is", "the", "and", "in", "of", "to", "a", "for", "on", "with")
    );

    public static void main(String[] args) {
    String folderPath = "docs";
    buildIndex(folderPath);

    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.print("\nEnter keyword to search (or type 'exit'): ");
        String keyword = scanner.nextLine().toLowerCase();

        if (keyword.equals("exit")) {
            System.out.println("Exiting search engine.");
            break;
        }

        searchKeyword(keyword);
    }

    scanner.close();
}


    // Step 1: Read documents and build index
    private static void buildIndex(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No documents found.");
            return;
        }

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    processLine(line, file.getName());
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + file.getName());
            }
        }
    }

    // Step 2: Process each line and update index
    private static void processLine(String line, String documentName) {
        String cleanedLine = line.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = cleanedLine.split("\\s+");

        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue; // skip stop words
            }

            invertedIndex
                .computeIfAbsent(word, k -> new HashMap<>())
                .merge(documentName, 1, Integer::sum);
        }
    }

    // Step 3: Search and rank results
    private static void searchKeyword(String keyword) {
        if (stopWords.contains(keyword)) {
            System.out.println("Keyword is a stop word. Please try a meaningful term.");
            return;
        }

        if (!invertedIndex.containsKey(keyword)) {
            System.out.println("No results found for: " + keyword);
            return;
        }

        Map<String, Integer> documents = invertedIndex.get(keyword);

        documents.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue() - a.getValue())
            .forEach(entry ->
                System.out.println(
                    "Document: " + entry.getKey() +
                    " | Frequency: " + entry.getValue()
                )
            );
    }
}
