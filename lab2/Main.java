package lab2;

import java.util.ArrayList;

import java.util.Arrays;

import lab2.model.Subscription;

import lab2.registration.StudentServiceImplementation;
import lab2.registration.CourseInstructorServiceImplementation;

public class Main {
    
    private static final ArrayList<Subscription> subscriptions = new ArrayList<>();

    private static final StudentServiceImplementation studentService = new StudentServiceImplementation(subscriptions);
    
    private static final CourseInstructorServiceImplementation instructorService = new CourseInstructorServiceImplementation(subscriptions);

    public static void main(String[] args) throws java.io.IOException {
        subscriptions.add(new Subscription(102, 100001));
        subscriptions.add(new Subscription(2023, 100002));

        System.out.println("Subcriptions: " + Arrays.toString(subscriptions.toArray()) + "\n");

        System.out.println("Subscribe student: " + studentService.subscribe(102, 100002)); //OK
        System.out.println("Subcriptions: " + Arrays.toString(subscriptions.toArray()) + "\n");

        System.out.println("Subscribe student: " + studentService.subscribe(2022, 100002)); //OK
        System.out.println("Subcriptions: " + Arrays.toString(subscriptions.toArray()) + "\n"); 

        System.out.println("Subscribe student: " + studentService.subscribe(2023, 100001)); //NOK
        System.out.println("Subcriptions: " + Arrays.toString(subscriptions.toArray()) + "\n");

        System.out.println("Unsubcribe student: " + studentService.unsubscribe(102, 100001)); //NOK
        System.out.println("Subcriptions: " + Arrays.toString(subscriptions.toArray()) + "\n");

        System.out.println("Unsubcribe student: " + studentService.unsubscribe(102, 100002)); //OK
        System.out.println("Subcriptions: " + Arrays.toString(subscriptions.toArray()) + "\n");

        System.out.println("findStudentsByCourseId(100002): " + Arrays.toString(instructorService.findStudentsByCourseId(100002))); // 2 id
        System.out.println("findStudentsByInstructorId(9001): " + Arrays.toString(instructorService.findStudentsByInstructorId(9001))); // 3 id
        System.out.println("findReplacement(9001, 19888): " + Arrays.toString(instructorService.findReplacement(9001, 19888))); //2 id
    }
}