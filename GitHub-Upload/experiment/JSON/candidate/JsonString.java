public final class JsonString {
    public static String quote(String input) {
        StringBuilder json = new StringBuilder();
        json.append('"');
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '"' -> json.append("\\\"");
                case '\\' -> json.append("\\\\");
                case '\b' -> json.append("\\b");
                case '\f' -> json.append("\\f");
                case '\n' -> json.append("\\n");
                case '\r' -> json.append("\\r");
                case '\t' -> json.append("\\t");
                default -> {
                    if (ch < 0x20 || Character.isSurrogate(ch)) {
                        json.append("\\u");
                        for (int shift = 12; shift >= 0; shift -= 4) {
                            json.append(Character.forDigit((ch >>> shift) & 0xF, 16));
                        }
                    } else {
                        json.append(ch);
                    }
                }
            }
        }

        return json.append('"').toString();
    }
}
