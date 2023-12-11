package lab2.model;

import java.util.List;

/**
 * Класс для информации о студенте
 */
public class Student extends Person {

    /**
     * список идентификаторов курсов (CourseInstance.id), пройденных студентом
     */
    private List<Long> completedCourses;

    // TODO: добавить геттеры и сеттеры
    
    public List<Long> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(List<Long> completedCourses) {
        this.completedCourses = completedCourses;
    }
}
