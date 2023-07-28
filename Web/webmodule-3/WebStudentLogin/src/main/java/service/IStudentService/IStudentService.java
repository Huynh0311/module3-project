package service.IStudentService;

import java.util.List;

public interface IStudentService<E> {
    void add(E e);
    int findIndexById(int id);
    void delete(int id);
    void edit(int id, E e);
    List<E> findAll();
}
