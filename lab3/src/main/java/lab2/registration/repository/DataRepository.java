package lab2.repository;

import java.io.IOException;

import java.util.List;

public interface DataRepository<Model> {
    
    List<Model> findAll() throws IOException;

    Model findById(long id) throws IOException;
}