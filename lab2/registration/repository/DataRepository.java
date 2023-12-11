package lab2.repository;

import java.io.IOException;

public interface DataRepository<Model> {
    
    Model[] findAll() throws IOException;

    Model findById(long id) throws IOException;
}