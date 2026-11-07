public final class JsonString {
    public static String quote(String input) {
        return "\"" + input.replace("\"", "\\\"") + "\"";
    }
}
