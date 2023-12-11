package lab2.registration;

import java.io.IOException;
import java.io.UncheckedIOException;

import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;

import lab2.model.Student;
import lab2.model.StudentCategory;

import lab2.model.ActionStatus;
import lab2.model.Subscription;

import lab2.model.CourseInfo;
import lab2.model.CourseInstance;

import lab2.service.StudentService;

import lab2.repository.StudentRepository;
import lab2.repository.CourseInfoRepository;
import lab2.repository.CourseInstanceRepository;

public class StudentServiceImplementation implements StudentService {
    
    private final StudentRepository studentRepository = new StudentRepository();
    private final CourseInfoRepository courseInfoRepository = new CourseInfoRepository();
    private final CourseInstanceRepository courseInstanceRepository = new CourseInstanceRepository();

    private List<Subscription> subscriptions;

    public StudentServiceImplementation(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public ActionStatus subscribe(long studentId, long courseId) {
        Student student;
        StudentCategory category;
        CourseInstance instance;
        CourseInfo info;

        try {
            student = studentRepository.findByIdAndCategory(studentId, StudentCategory.BACHELOR);
            if (student != null) {
                category = StudentCategory.BACHELOR;
            } else {
                category = StudentCategory.MASTER;
            }

            instance = courseInstanceRepository.findById(courseId);
            info = courseInfoRepository.findById(instance.getCourseId());
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        if (instance.getStartDate().toEpochDay() <= LocalDate.now().toEpochDay()) {
            return ActionStatus.NOK;
        }

        if (!info.getStudentCategories().contains(category)) {
            return ActionStatus.NOK;
        }
        
        List<Long> prerequisites = info.getPrerequisites();
        if (prerequisites != null) {
            boolean isCompleted = student.getCompletedCourses()
                .stream()
                .filter(completed -> prerequisites.contains(completed))
                .count() > 0;

            if (!isCompleted) {
                return ActionStatus.NOK;
            }
        }

        if (instance.getCapacity() <= findAllSubscriptionsByCourseId(courseId).length) {
            return ActionStatus.NOK;
        }

        Subscription subscription = new Subscription(studentId, courseId);
        subscriptions.add(subscription);
        return ActionStatus.OK;
    }

    @Override
    public ActionStatus unsubscribe(long studentId, long courseId) {
        CourseInstance instance;
        try {
            instance = courseInstanceRepository.findById(courseId);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        List<Subscription> subscriptionsToRemove = subscriptions.stream()
            .filter(subscription -> subscription.getStudentId() == studentId && subscription.getCourseId() == courseId
                && instance.getStartDate().toEpochDay() > LocalDate.now().toEpochDay()).toList();

        subscriptionsToRemove.forEach(subscription -> {
            subscriptions.remove(subscription);
        });

        return subscriptionsToRemove.size() > 0 ? ActionStatus.OK : ActionStatus.NOK;
    }

    @Override
    public CourseInstance[] findAllSubscriptionsByStudentId(long studentId) {
        return subscriptions.stream().map(subscription -> {
            if (subscription.getStudentId() == studentId) {
                long courseInstanceId = subscription.getCourseId();

                CourseInstance instance;
                try {
                    instance = courseInstanceRepository.findById(courseInstanceId);
                } catch (IOException exception) {
                    throw new UncheckedIOException(exception);
                }
                return instance;
            }
            return null;
        }).toList().toArray(new CourseInstance[0]);
    }

    public Subscription[] findAllSubscriptionsByCourseId(long courseId) {
        return subscriptions.stream().filter(subscription -> subscription.getCourseId() == courseId).toList().toArray(new Subscription[0]);
    }
}