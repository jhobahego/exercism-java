import java.util.stream.Collectors;

class MicroBlog {
    public String truncate(String input) {
        int[] codePointArray = input.codePoints().toArray();

        if( codePointArray.length > 5 ){
            return new String(codePointArray, 0, 5);
        }
        return input;

//        int len = 0;
//        for(char letter : codePointArray) {
//            if(len < 5) {
//                sb.append(letter);
//                len++;
//            }
//        }

//        StringBuilder sb = new StringBuilder();
//        input.codePoints()
//                .limit(5)
//                .forEach(e -> sb.appendCodePoint(e)); 1.option
//                .mapToObj(Character::toString) 2.option
//                .collect(Collectors.joining());

//        return sb.toString();
    }
}
