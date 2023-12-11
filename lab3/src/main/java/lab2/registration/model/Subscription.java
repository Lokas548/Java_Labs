package lab2.model;

public class Subscription {

    private long id;

    private long courseId;
    
    private long studentId;

    public Subscription() {
    }

    public Subscription(long studentId, long courseId) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.id = courseId+studentId;
    } 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Subcription{id=" + id + ", courseId=" + courseId + ", studentId=" + studentId + "}";
    }
}