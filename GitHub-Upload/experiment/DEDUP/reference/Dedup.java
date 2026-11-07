import java.util.LinkedHashSet;
import java.util.Set;

public final class Dedup {
    public static int[] unique(int[] values) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int value : values) {
            seen.add(value);
        }
        return seen.stream().mapToInt(Integer::intValue).toArray();
    }
}
