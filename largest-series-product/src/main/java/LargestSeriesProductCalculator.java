import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("^\\d+$") && inputNumber.length() > 0) throw new IllegalArgumentException("String to search may only contain digits.");

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else if(inputNumber.length() < numberOfDigits) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        return getMax(this.inputNumber, numberOfDigits);
    }

    public Long getMax(String numberText, int range) {
        List<Long> numbers = IntStream.range(0, numberText.length() - range + 1)
                .mapToObj(i -> Arrays.stream(numberText.split(""))
                        .skip(i)
                        .mapToLong(Long::parseLong)
                        .limit(range)
                        .reduce(1, (val1, val2) -> val1 * val2)).collect(Collectors.toList());

        Optional<Long> max = numbers.stream().max(Long::compare);
        return max.orElse(0L);
    }
}
