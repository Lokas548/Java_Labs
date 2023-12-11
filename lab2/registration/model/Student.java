package lab2.model;

/**
 * Класс для информации о студенте
 */
public class Student extends Person {

    /**
     * список идентификаторов курсов (CourseInstance.id), пройденных студентом
     */
    private long[] completedCourses;

    // TODO: добавить геттеры и сеттеры
    
    public long[] getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(long[] completedCourses) {
        this.completedCourses = completedCourses;
    }
}
