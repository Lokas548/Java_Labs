package lab2.repository;

import java.io.IOException;

import lab2.model.Student;
import lab2.model.StudentCategory;

import lab2.reader.StudentDataReader;

public class StudentRepository implements DataRepository<Student> {
    
    private final StudentDataReader reader = new StudentDataReader();

    @Override
    public Student[] findAll() throws IOException {
        Student[] bachelorStudents = reader.readBachelorStudentData();
        Student[] masterStudents = reader.readMasterStudentData();

        Student[] students = new Student[bachelorStudents.length+masterStudents.length];
        System.arraycopy(bachelorStudents, 0, students, 0, bachelorStudents.length);
        System.arraycopy(masterStudents, 0, students, bachelorStudents.length, masterStudents.length);

        return students;
    }

    @Override
    public Student findById(long id) throws IOException {
        Student[] students = findAll();
        return findByIdInArray(id, students);
    }

    public Student findByIdAndCategory(long id, StudentCategory category) throws IOException {
        return switch (category) {
            case BACHELOR -> findByIdInArray(id, reader.readBachelorStudentData());
            case MASTER -> findByIdInArray(id, reader.readMasterStudentData());
            default -> null;
        };
    }

    private Student findByIdInArray(long id, Student[] students) throws IOException {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        
        return null;
    }
}