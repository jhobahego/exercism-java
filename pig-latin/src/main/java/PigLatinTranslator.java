import java.util.*;

public class PigLatinTranslator {
    List<String> vowelsSounds = setVowelSounds();

    public String translate(String word) {
        List<String> words = new ArrayList<>(List.of(word.trim().split(" ")));
        if (words.size() > 1) {
            StringBuilder sb = new StringBuilder();
            for(String wordInWord : words){
                String newWord = translateWordOrPhrase(wordInWord);
                sb.append(newWord).append(" ");
            }

            return sb.toString().trim();
        }

        return translateWordOrPhrase(word);
    }

    public List<String> setVowelSounds(){
        Set<String> noRepeated = new HashSet<>();
        String alfabet = "abcdefghijklmnopqrstuvwz";

        for (int i = 0; i < 24; i++) {
            String character = Character.toString(alfabet.charAt(i));
            if("aeiou".contains(character)){
                noRepeated.add(character);
                continue;
            }
            noRepeated.add("y".concat(character));
            noRepeated.add("x".concat(character));
        }

        return new ArrayList<>(noRepeated);
    }

    public String translateWordOrPhrase(String word){
        StringBuilder sb = new StringBuilder();
        sb.append(word.trim());
        while(true){
            String firstLetter = String.valueOf(sb.toString().charAt(0));
            String firstTwoLetter = firstLetter + sb.toString().charAt(1);
            if(vowelsSounds.contains(firstLetter) || vowelsSounds.contains(firstTwoLetter)){
                sb.append("ay");
                break;
            }else if(firstTwoLetter.equals("qu")){
                String temp = sb.toString().replaceFirst(firstTwoLetter, "").concat(firstTwoLetter);
                sb.delete(0, sb.length());
                sb.append(temp);
                continue;
            }

            String temp = sb.toString().replaceFirst(firstLetter, "").concat(firstLetter);
            sb.delete(0, sb.length());
            sb.append(temp);
        }

        return sb.toString();
    }
}
