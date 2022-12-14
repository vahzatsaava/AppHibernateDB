package company.repository;

import java.util.List;

public interface GenericRepository<T,ID> {
    T findByID(int id);

    T save(T t);

    T update(T t);

    List<T> getAll();

    void delete(int id);
}
