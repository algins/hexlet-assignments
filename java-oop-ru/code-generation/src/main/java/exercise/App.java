package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) {
        try {
            Files.writeString(path, car.serialize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        try {
            var json = Files.readString(path);
            return Car.unserialize(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
// END
