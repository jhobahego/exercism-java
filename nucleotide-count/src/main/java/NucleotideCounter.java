import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {
    private final String DNA_SEQUENCE;

    public NucleotideCounter(String dnaSequence) {
        if (!dnaSequence.toLowerCase().matches("[acgt]+") && dnaSequence.length() > 0) throw new IllegalArgumentException("error");
        this.DNA_SEQUENCE = dnaSequence;
    }

    public Map<Character, Integer> nucleotideCounts() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        for (Character c : this.DNA_SEQUENCE.toCharArray()) {
            map.merge(c,1, Integer::sum);
        }
        return map;
    }
}