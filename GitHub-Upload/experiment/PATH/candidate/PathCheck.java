import java.util.ArrayList;
import java.util.List;

public final class PathCheck {
    public static boolean contains(String base, String candidate) {
        List<String> baseSegments = normalize(base);
        List<String> candidateSegments = normalize(candidate);
        return candidateSegments.size() >= baseSegments.size()
                && candidateSegments.subList(0, baseSegments.size()).equals(baseSegments);
    }

    private static List<String> normalize(String path) {
        List<String> segments = new ArrayList<>();

        for (String segment : path.split("/")) {
            if (segment.isEmpty() || segment.equals(".")) {
                continue;
            }

            if (segment.equals("..")) {
                if (!segments.isEmpty()) {
                    segments.remove(segments.size() - 1);
                }
            } else {
                segments.add(segment);
            }
        }

        return segments;
    }
}
