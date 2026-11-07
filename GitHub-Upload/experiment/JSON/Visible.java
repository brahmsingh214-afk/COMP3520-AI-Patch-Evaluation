public final class Visible {
    public static void main(String[] args) {
        check("\\");
    }

    static void check(String input) {
        String json = JsonString.quote(input);
        StringBuilder decoded = new StringBuilder();
        int end = json.length() - 1;
        if (end < 1 || json.charAt(0) != '"' || json.charAt(end) != '"') {
            throw new AssertionError("Missing JSON quotes");
        }
        for (int i = 1; i < end; i++) {
            char ch = json.charAt(i);
            if (ch == '\\') {
                if (++i >= end) throw new AssertionError("Incomplete escape");
                ch = json.charAt(i);
                switch (ch) {
                    case '"', '\\', '/' -> decoded.append(ch);
                    case 'b' -> decoded.append('\b');
                    case 'f' -> decoded.append('\f');
                    case 'n' -> decoded.append('\n');
                    case 'r' -> decoded.append('\r');
                    case 't' -> decoded.append('\t');
                    case 'u' -> {
                        if (i + 4 >= end) throw new AssertionError("Incomplete Unicode escape");
                        String hex = json.substring(i + 1, i + 5);
                        if (!hex.matches("[0-9a-fA-F]{4}")) throw new AssertionError("Invalid Unicode escape");
                        decoded.append((char) Integer.parseInt(hex, 16));
                        i += 4;
                    }
                    default -> throw new AssertionError("Invalid JSON escape");
                }
            } else {
                if (ch == '"' || ch < 32) throw new AssertionError("Unescaped character");
                decoded.append(ch);
            }
        }
        if (!input.contentEquals(decoded)) throw new AssertionError("Round trip changed the input");
    }
}
