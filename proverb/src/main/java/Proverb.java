import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Proverb {
    public String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        List<String> phrases = new ArrayList<>();
        if(words.length == 0) return "";

        if(words.length == 1) return "And all for the want of a "+words[0]+".";

        for(int i = 0; i< words.length-1; i++){
            String proverb = "For want of a "+words[i]+" the "+words[i+1]+" was lost.\n";
            phrases.add(proverb);
        }
        String lastPhrase = "And all for the want of a "+words[0]+".";
        phrases.add(lastPhrase);

        return String.join("", phrases);
    }

}
