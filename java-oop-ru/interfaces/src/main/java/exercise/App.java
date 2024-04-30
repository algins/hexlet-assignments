package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> appartments, int count) {
        return appartments.stream()
            .sorted((a, b) -> a.compareTo(b))
            .limit(count)
            .map(item -> item.toString())
            .collect(Collectors.toList());
    }
}
// END
