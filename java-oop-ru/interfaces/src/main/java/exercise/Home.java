package exercise;

// BEGIN
public interface Home {
    double getArea();
    
    default int compareTo(Home another) {
        var totalArea = getArea();
        var anotherTotalArea = another.getArea();

        if (totalArea > anotherTotalArea) {
            return 1;
        }

        if (totalArea < anotherTotalArea) {
            return -1;
        }

        return 0;
    }
}
// END
