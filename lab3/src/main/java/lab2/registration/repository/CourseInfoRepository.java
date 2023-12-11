package lab2.repository;

import java.io.IOException;

import java.util.List;

import lab2.model.CourseInfo;
import lab2.reader.CourseDataReader;

public class CourseInfoRepository implements DataRepository<CourseInfo> {

    private final CourseDataReader reader = new CourseDataReader();

    @Override
    public List<CourseInfo> findAll() throws IOException {
        return reader.readCourseInfoData();
    }

    @Override
    public CourseInfo findById(long id) throws IOException {
        return findAll().stream().filter(info -> info.getId() == id).findFirst().orElse(null);
    }
}