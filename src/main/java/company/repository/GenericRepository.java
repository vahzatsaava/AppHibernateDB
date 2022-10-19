package company.repository;

import java.util.List;

public interface GenericRepository<T> {
    T findByID(int id);

    T save(T t);

    T update(int id, T t);

    List<T> getAll();

    void delete(int id);
}
