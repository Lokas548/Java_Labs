package lab2.registration;

import java.io.IOException;
import java.io.UncheckedIOException;

import java.util.List;
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
        List<Student> students = new ArrayList<>();

        for (Subscription subscription : subscriptions) {
            if (subscription.getCourseId() == courseId) {
                Student student;

                try {
                    student = studentRepository.findById(subscription.getStudentId());
                } catch (IOException exception) {
                    throw new UncheckedIOException(exception);
                }

                students.add(student);
            }
        }

        return students.toArray(new Student[0]);
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

        int[] canTeach = instructor.getCanTeach();
        if (canTeach == null) {
            return new Student[0];
        }

        for (int courseId : canTeach) {
            for (Subscription subscription : subscriptions) {
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
            }
        }

        return students.toArray(new Student[0]);
    }

    @Override
    public Instructor[] findReplacement(long instructorId, long courseId) {
        Instructor[] instructors;
        List<Instructor> foundInstructors = new ArrayList<>();

        try {
            instructors = instructorRepository.findAll();
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        for (Instructor instructor : instructors) {
            for (int canTeach : instructor.getCanTeach()) {
                if (instructor.getId() != instructorId && canTeach == courseId) {
                    foundInstructors.add(instructor);
                }
            }
        }

        return foundInstructors.toArray(new Instructor[0]);
    }
}