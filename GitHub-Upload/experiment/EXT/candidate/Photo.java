public final class Photo {
    public static boolean isJpg(String name) {
        int start = name.length() - 4;
        if (start <= 0 || name.charAt(start) != '.') {
            return false;
        }

        char j = name.charAt(start + 1);
        char p = name.charAt(start + 2);
        char g = name.charAt(start + 3);
        return (j == 'j' || j == 'J')
                && (p == 'p' || p == 'P')
                && (g == 'g' || g == 'G');
    }
}
