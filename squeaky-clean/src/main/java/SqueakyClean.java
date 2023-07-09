class SqueakyClean {
    static String clean(String identifier) {
        if (identifier.length() == 0) {
            return identifier;
        }
        String result = "";
        StringBuilder sb = new StringBuilder();
        boolean esCap = false;
        for(int i = 0; i < identifier.length(); i++) {
            if (Character.isSpaceChar(identifier.charAt(i))) {
                sb.append('_');
            } else if (Character.isISOControl(identifier.charAt(i))) {
                sb.append("CTRL");
            } else if (!Character.isLetter(identifier.charAt(i)) && identifier.charAt(i) == '-') {
                esCap = true;
            } else if (esCap){
                sb.append(Character.toUpperCase(identifier.charAt(i)));
                esCap = false;
            }else if ((identifier.charAt(i) < 0x3B1) || (identifier.charAt(i) > 0x3C9)) {
                sb.append(identifier.charAt(i));
            }
        }

        return sb.toString();
    }
}
