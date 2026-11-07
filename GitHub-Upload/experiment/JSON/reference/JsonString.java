public final class JsonString {
    public static String quote(String input) {
        StringBuilder result = new StringBuilder("\"");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '"' || ch == '\\') {
                result.append('\\').append(ch);
            } else if (ch < 32 || Character.isSurrogate(ch)) {
                result.append(String.format("\\u%04x", (int) ch));
            } else {
                result.append(ch);
            }
        }
        return result.append('"').toString();
    }
}
