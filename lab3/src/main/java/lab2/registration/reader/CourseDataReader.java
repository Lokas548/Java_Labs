package lab2.reader;

import java.io.File;
import java.io.IOException;

import java.util.List;

import lab2.model.CourseInfo;
import lab2.model.CourseInstance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class CourseDataReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CourseDataReader() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<CourseInfo> readCourseInfoData() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/courseInfos.json"), new TypeReference<List<CourseInfo>>(){});
    }

    public List<CourseInstance> readCourseInstanceData() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/courseInstances.json"), new TypeReference<List<CourseInstance>>(){});
    }
}