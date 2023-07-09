import java.util.*;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> countedWords = new HashMap<>();

        String normalizeInput = input.toLowerCase().replaceAll("[^a-z0-9']", " ").trim();

        List<String> wordsArray = new ArrayList<>(Arrays.asList(normalizeInput.split("\\s+")));

        for(String word: wordsArray) {
            String cleanWord = word.replaceAll("^'|'$", "");
            countedWords.put(cleanWord, countedWords.getOrDefault(word, 0) + 1);
        }

        return countedWords;
    }

}
