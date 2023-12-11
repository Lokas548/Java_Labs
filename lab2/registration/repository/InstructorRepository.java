package lab2.repository;

import java.io.IOException;

import lab2.model.Instructor;

import lab2.reader.InstructorDataReader;

public class InstructorRepository implements DataRepository<Instructor>  {

    private final InstructorDataReader reader = new InstructorDataReader();

    @Override
    public Instructor[] findAll() throws IOException {
        return reader.readInstructorData();
    }

    @Override
    public Instructor findById(long id) throws IOException {
        Instructor[] instructors = findAll();
        for (Instructor instructor : instructors) {
            if (instructor.getId() == id) {
                return instructor;
            }
        }

        return null;
    }
}
