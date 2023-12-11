package lab2.reader;

import java.io.IOException;
import java.io.File;

import lab2.model.Instructor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InstructorDataReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Instructor[] readInstructorData() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/instructors.json"), Instructor[].class);
    }
}