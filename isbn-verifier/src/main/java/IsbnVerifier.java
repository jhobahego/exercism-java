//import java.util.List;
//import java.util.stream.Collectors;

class IsbnVerifier {

//    String formula = "(x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0";

    boolean isValid(String stringToVerify) {
//        List<Integer> values = (List<Integer>) stringToVerify.chars().filter(IsbnVerifier::validLetter);
        if (!validFormat(stringToVerify)) return false;

        stringToVerify = stringToVerify.replaceAll("-", "");

        int size = stringToVerify.length();
        int suma = 0;
        for (int i = 0; i < stringToVerify.length(); i++) {
            char c = stringToVerify.charAt(i);

            int numero = validX(c);

            suma += numero * size--;
        }

        return suma % 11 == 0;
    }

    int validX(char c) {
        return c == 'X' ? 10 : Integer.parseInt(String.valueOf(c));
    }

    static boolean validFormat(String text) {
        String newString = text.replaceAll("-", "");

        return newString.matches("^\\d{9}[0-9X]$");
    }

}
