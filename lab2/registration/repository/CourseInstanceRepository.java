package lab2.repository;

import java.io.IOException;

import lab2.model.CourseInstance;

import lab2.reader.CourseDataReader;

public class CourseInstanceRepository implements DataRepository<CourseInstance> {

    private final CourseDataReader reader = new CourseDataReader();

    @Override
    public CourseInstance[] findAll() throws IOException {
        return reader.readCourseInstanceData();
    }

    @Override
    public CourseInstance findById(long id) throws IOException {
        CourseInstance[] instances = findAll();
        for (CourseInstance instance : instances) {

            if (instance.getId() == id) {
                return instance;
            }
        }

        return null;
    }
}