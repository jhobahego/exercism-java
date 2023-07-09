class RaindropConverter {

    String convert(int number) {
        if (number % 3 > 0 && number % 5 > 0 && number % 7 > 0) {
            return number + "";
        }
        StringBuilder sb = new StringBuilder();
        if(number % 3 == 0) {
            sb.append("Pling");
        }
        if (number % 5 == 0) {
            sb.append("Plang");
        }
        if(number % 7 == 0) {
            sb.append("Plong");
        }

        return sb.toString();
    }

}
