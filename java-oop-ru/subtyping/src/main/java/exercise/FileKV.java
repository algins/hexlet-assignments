package exercise;

// BEGIN
import java.util.Map;
import java.util.HashMap;

class FileKV implements KeyValueStorage {
    private String path;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        store(map);
    }

    public void set(String key, String value) {
        var map = toMap();
        map.put(key, value);
        store(map);
    }

    public void unset(String key) {
        var map = toMap();
        map.remove(key);
        store(map);
    }

    public String get(String key, String defaultValue) {
        var map = toMap();
        return map.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        var content = Utils.readFile(path);
        var map = Utils.unserialize(content);
        return new HashMap<String, String>(map);
    }

    private void store(Map<String, String> map) {
        var content = Utils.serialize(map);
        Utils.writeFile(path, content);
    }
}
// END
