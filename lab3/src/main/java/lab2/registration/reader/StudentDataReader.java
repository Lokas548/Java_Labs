package lab2.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lab2.model.Student;

import java.util.List;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;
/**
 * Класс для чтения информации о студентах из файлов
 */
public class StudentDataReader {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @return список студентов-бакалавров
     */
    public List<Student> readBachelorStudentData() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/bachelorStudents.json"), new TypeReference<List<Student>>(){});
    }

    /**
     * @return список студентов-магистров
     */
    public List<Student> readMasterStudentData() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/masterStudents.json"), new TypeReference<List<Student>>(){});
    }
}
