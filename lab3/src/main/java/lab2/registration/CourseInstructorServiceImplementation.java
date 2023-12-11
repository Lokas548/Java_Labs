package lab2.registration;

import java.io.IOException;
import java.io.UncheckedIOException;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import lab2.service.CourseInstructorService;

import lab2.model.Student;
import lab2.model.Instructor;
import lab2.model.Subscription;
import lab2.model.CourseInstance;

import lab2.repository.StudentRepository;
import lab2.repository.InstructorRepository;
import lab2.repository.CourseInstanceRepository;

public class CourseInstructorServiceImplementation implements CourseInstructorService {
    
    private final StudentRepository studentRepository = new StudentRepository();
    private final InstructorRepository instructorRepository = new InstructorRepository();
    private final CourseInstanceRepository courseInstanceRepository = new CourseInstanceRepository();

    private List<Subscription> subscriptions;

    public CourseInstructorServiceImplementation(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override 
    public Student[] findStudentsByCourseId(long courseId) {
        return subscriptions.stream()
            .filter(subscription -> subscription.getCourseId() == courseId)
            .map(subscription -> {
                Student student;

                try {
                    student = studentRepository.findById(subscription.getStudentId());
                } catch (IOException exception) {
                    throw new UncheckedIOException(exception);
                }

                return student;
            }).toList().toArray(new Student[0]);
    }

    @Override
    public Student[] findStudentsByInstructorId(long instructorId) {
        List<Student> students = new ArrayList<>();
        Instructor instructor;

        try {
            instructor = instructorRepository.findById(instructorId);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        List<Integer> canTeach = instructor.getCanTeach();
        if (canTeach == null) {
            return new Student[0];
        }

        canTeach.stream().forEach(courseId -> 
            subscriptions.stream().forEach(subscription -> {
                CourseInstance instance;
                
                try {
                    instance = courseInstanceRepository.findById(subscription.getCourseId());
                } catch (IOException exception) {
                    throw new UncheckedIOException(exception);
                }

                if (instance.getCourseId() == courseId) {
                    Student student;

                    try {
                        student = studentRepository.findById(subscription.getStudentId());
                    } catch (IOException exception) {
                        throw new UncheckedIOException(exception);
                    }

                    if (!students.contains(student)) {
                        students.add(student);
                    }
                }
            }));

        return students.toArray(new Student[0]);
    }

    @Override
    public Instructor[] findReplacement(long instructorId, long courseId) {
        List<Instructor> instructors;
        List<Instructor> foundInstructors = new ArrayList<>();

        try {
            instructors = instructorRepository.findAll();
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        instructors.stream().forEach(instructor ->
            instructor.getCanTeach().stream().forEach(canTeach -> {
                if (instructor.getId() != instructorId && canTeach == courseId) {
                    foundInstructors.add(instructor);
                }
            }));

        return foundInstructors.toArray(new Instructor[0]);
    }
}