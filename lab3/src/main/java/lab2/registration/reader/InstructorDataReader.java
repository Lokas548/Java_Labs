package lab2.reader;

import java.io.IOException;
import java.io.File;

import lab2.model.Instructor;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class InstructorDataReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Instructor> readInstructorData() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/instructors.json"), new TypeReference<List<Instructor>>(){});
    }
}