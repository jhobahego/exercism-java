import java.util.Map;

public class PhoneNumber {

    private final String phoneNumber;

    public PhoneNumber(String numberReceived) {
        String cleanedNumber = numberReceived.replaceAll("[+\\-(). ]", "");

        String validNumber = validateNumber(cleanedNumber); // validate if the number is valid

        String numberWithValidCodes = validateCodes(validNumber); // validate if the number has correct area and exchange codes

        this.phoneNumber = numberWithValidCodes;
    }

    public String getNumber() {
        return this.phoneNumber;
    }

    private String validateNumber(String cleanedNumber) {
        if (cleanedNumber.matches(".*[a-z].*")) throw new IllegalArgumentException("letters not permitted");
        if (cleanedNumber.matches(".*[\\p{Punct}].*")) throw new IllegalArgumentException("punctuations not permitted");

        if(cleanedNumber.length() < 10) throw new IllegalArgumentException("incorrect number of digits");
        if (cleanedNumber.length() > 11) throw new IllegalArgumentException("more than 11 digits");

        if (cleanedNumber.length() > 10 && !cleanedNumber.startsWith("1"))
            throw new IllegalArgumentException("11 digits must start with 1");

        return cleanedNumber;
    }

    public String validateCodes(String number) {
        Map<Character, String> map = Map.of('0', "zero", '1', "one");

        if (number.length() == 11 && number.startsWith("1"))
            number = number.substring(1);

        char areaCode = number.charAt(0);
        char exchangeCode = number.charAt(3);

        if (areaCode == '0' || areaCode == '1')
            throw new IllegalArgumentException("area code cannot start with "+map.get(areaCode));
        if (exchangeCode == '0' || exchangeCode == '1')
            throw new IllegalArgumentException("exchange code cannot start with "+map.get(exchangeCode));

        return number;
    }
}