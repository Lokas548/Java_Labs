package lab2.repository;

import java.io.IOException;

import java.util.List;

import lab2.model.Instructor;

import lab2.reader.InstructorDataReader;

public class InstructorRepository implements DataRepository<Instructor>  {

    private final InstructorDataReader reader = new InstructorDataReader();

    @Override
    public List<Instructor> findAll() throws IOException {
        return reader.readInstructorData();
    }

    @Override
    public Instructor findById(long id) throws IOException {
        return findAll().stream().filter(instructor -> instructor.getId() == id).findFirst().orElse(null);
    }
}
