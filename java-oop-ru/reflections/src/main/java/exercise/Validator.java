package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        ArrayList<String> invalidFields = new ArrayList<>();

        for (Field field : address.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.getAnnotation(NotNull.class) != null && field.get(address) == null) {
                    invalidFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return invalidFields;
    }
}
// END
