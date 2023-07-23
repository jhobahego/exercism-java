import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class HighScores {

    private final List<Integer> scores;
    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
    }

    List<Integer> scores() {
        return this.scores;
    }

    Integer latest() {
        return this.scores.get(this.scores.size() - 1);
    }

    Integer personalBest() {
        return this.scores.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    List<Integer> personalTopThree() {
        int listSize = this.scores.size();
        int iterations = Math.min(listSize, 3);

        return this.scores.stream()
                .sorted(Comparator.reverseOrder())
                .limit(iterations)
                .collect(Collectors.toList());
    }

}
