import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class LuhnValidator {

    boolean isValid(String candidate) {
        final String text = candidate.replaceAll(" ", "");

        if (!text.matches("^\\d+$") || text.length() < 2) return false;

        int result = IntStream.range(0, text.length())
                .map(i -> getDoubleNumber(i, text))
                .reduce(0, Integer::sum);

        return result % 10 == 0;
    }

    private static Integer getDoubleNumber(int i, String text) {
        String reverseText = new StringBuilder(text).reverse().toString();

        int number = Character.getNumericValue(reverseText.charAt(i));
        if((i + 1) % 2 == 0) { // if iteration is even number would be doubled
            int doubleNumber = number * 2;

            return doubleNumber > 9 ? doubleNumber - 9 : doubleNumber; // validating if the doubled number is greater than 9
        }
        return number; // odd iteration does not need to be doubled
    }
}
