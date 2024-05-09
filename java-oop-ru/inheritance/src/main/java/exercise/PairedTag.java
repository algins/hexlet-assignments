package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        this.name = name;
        this.attributes = attributes;
        this.body = body;
        this.children = children;
    }

    public String toString() {
        var childrenString = children.stream()
            .map(item -> item.toString())
            .collect(Collectors.joining(""));

        return "<" + name + getAttributeString() + ">" + body + childrenString + "</" + name + ">";
    }
}
// END
