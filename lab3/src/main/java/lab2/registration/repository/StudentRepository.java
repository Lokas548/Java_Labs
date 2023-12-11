package lab2.repository;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import lab2.model.Student;
import lab2.model.StudentCategory;

import lab2.reader.StudentDataReader;

public class StudentRepository implements DataRepository<Student> {
    
    private final StudentDataReader reader = new StudentDataReader();

    @Override
    public List<Student> findAll() throws IOException {
        List<Student> students = new ArrayList<>();
        students.addAll(reader.readBachelorStudentData());
        students.addAll(reader.readMasterStudentData());
        return students;
    }

    @Override
    public Student findById(long id) throws IOException {
        return findByIdInArray(id, findAll());
    }

    public Student findByIdAndCategory(long id, StudentCategory category) throws IOException {
        return switch (category) {
            case BACHELOR -> findByIdInArray(id, reader.readBachelorStudentData());
            case MASTER -> findByIdInArray(id, reader.readMasterStudentData());
            default -> null;
        };
    }

    private Student findByIdInArray(long id, List<Student> students) throws IOException {
        return findAll().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }
}