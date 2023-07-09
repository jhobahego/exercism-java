import java.util.HashMap;
import java.lang.*;

class Scrabble {
    String palabra = "";
    Scrabble(String word) {
        palabra = word.trim().toUpperCase();    
    }
    int getScore() {
        int score = 0;
        String val1 = "AEIOULNRST";
        String val2 = "DG";
        String val3 = "BCMP";
        String val4 = "FHVWY";
        String val8 = "JX";
        String val10 = "QZ";

        HashMap<Character, Integer> scores = new HashMap<>();
        for(int i = 0; i < val1.length(); i++){
            scores.put(val1.charAt(i), 1);
        }

        for(int i = 0; i < val2.length(); i++){
            scores.put(val2.charAt(i), 2);
        }

        for(int i = 0; i < val3.length(); i++){
            scores.put(val3.charAt(i), 3);
        }

        for(int i = 0; i < val4.length(); i++){
            scores.put(val4.charAt(i), 4);
        }

        for(int i = 0; i < val8.length(); i++){
            scores.put(val8.charAt(i), 8);
        }

        for(int i = 0; i < val10.length(); i++){
            scores.put(val10.charAt(i), 10);
        }

        for(int i = 0; i < palabra.length(); i++){
            if(scores.containsKey(palabra.charAt(i))){
                score += scores.get(palabra.charAt(i));
            }
        }
        
        return score;
    }

}
