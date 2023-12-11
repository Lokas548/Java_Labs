package lab2.repository;

import java.io.IOException;

import lab2.model.CourseInstance;

import java.util.List;

import lab2.reader.CourseDataReader;

public class CourseInstanceRepository implements DataRepository<CourseInstance> {

    private final CourseDataReader reader = new CourseDataReader();

    @Override
    public List<CourseInstance> findAll() throws IOException {
        return reader.readCourseInstanceData();
    }

    @Override
    public CourseInstance findById(long id) throws IOException {
        return findAll().stream().filter(instance -> instance.getId() == id).findFirst().orElse(null);
    }
}