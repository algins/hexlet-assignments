package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    protected String name;
    protected Map<String, String> attributes;

    protected String getAttributeString() {
        if (attributes.isEmpty()) {
            return "";
        }

        var attributesString = attributes.entrySet()
            .stream()
            .map(item -> item.getKey() + "=\"" + item.getValue() + "\"")
            .collect(Collectors.joining(" "));

        return " " + attributesString;
    }
}
// END
