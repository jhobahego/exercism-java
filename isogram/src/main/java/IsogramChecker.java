import java.util.*;
//import java.util.stream.Stream;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        String normalizeWord = phrase.replaceAll("[- ]+", "").toLowerCase();

        List<Character> characters = new ArrayList<>();
        for(char c : normalizeWord.toCharArray()){
            if(characters.contains(c)){
                return false;
            }
            characters.add(c);
        }
//        return (normalizeWord.chars().distinct().count() == normalizeWord.length());
        return true;
    }

}
