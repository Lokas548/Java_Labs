package lab2.repository;

import java.io.IOException;

import lab2.model.CourseInfo;
import lab2.reader.CourseDataReader;

public class CourseInfoRepository implements DataRepository<CourseInfo> {

    private final CourseDataReader reader = new CourseDataReader();

    @Override
    public CourseInfo[] findAll() throws IOException {
        return reader.readCourseInfoData();
    }

    @Override
    public CourseInfo findById(long id) throws IOException {
        CourseInfo[] infos = findAll();
        for (CourseInfo info : infos) {

            if (info.getId() == id) {
                return info;
            }
        }

        return null;
    }
}