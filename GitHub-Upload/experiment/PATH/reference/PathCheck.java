import java.util.ArrayList;
import java.util.List;

public final class PathCheck {
    public static boolean contains(String base, String candidate) {
        List<String> parent = segments(base);
        List<String> child = segments(candidate);
        return child.size() >= parent.size()
            && child.subList(0, parent.size()).equals(parent);
    }

    private static List<String> segments(String path) {
        List<String> result = new ArrayList<>();
        for (String segment : path.split("/")) {
            switch (segment) {
                case "", "." -> {}
                case ".." -> {
                    if (!result.isEmpty()) {
                        result.remove(result.size() - 1);
                    }
                }
                default -> result.add(segment);
            }
        }
        return result;
    }
}
