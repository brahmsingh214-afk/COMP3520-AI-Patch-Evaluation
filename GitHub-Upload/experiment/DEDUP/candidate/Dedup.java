import java.util.Arrays;

public final class Dedup {
public static int[] unique(int[] values) {
return Arrays.stream(values).distinct().toArray();
}
}
