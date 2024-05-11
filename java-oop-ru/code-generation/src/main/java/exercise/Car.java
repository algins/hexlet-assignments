package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@AllArgsConstructor
@Getter
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Car unserialize(String json) throws JsonParseException, JsonMappingException, IOException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, Car.class);	
    }
    // END
}
