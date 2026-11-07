public final class Independent {
    public static void main(String[] args) {
        int[] input = {2, 2, -1, 2, -1, 0};
        int[] original = input.clone();
        Visible.check(new int[]{2, -1, 0}, Dedup.unique(input));
        Visible.check(original, input);
        Visible.check(new int[]{}, Dedup.unique(new int[]{}));
    }
}
