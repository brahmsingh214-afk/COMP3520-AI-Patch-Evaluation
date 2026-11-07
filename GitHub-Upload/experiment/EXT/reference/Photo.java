public final class Photo {
    public static boolean isJpg(String name) {
        int i = name.length() - 4;
        return i > 0 && name.charAt(i) == '.'
            && (name.charAt(i + 1) == 'j' || name.charAt(i + 1) == 'J')
            && (name.charAt(i + 2) == 'p' || name.charAt(i + 2) == 'P')
            && (name.charAt(i + 3) == 'g' || name.charAt(i + 3) == 'G');
    }
}
