package service;

import model.Student;
import service.IStudentService.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService<Student> {
    private List<Student> students = new ArrayList<>();
    public StudentService() {
        this.students.add(new Student(1,"Linh",20, "https://taimienphi.vn/tmp/cf/aut/anh-gai-xinh-1.jpg"));
    }
    @Override
    public void add(Student student) {
        this.students.add(student);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        this.students.remove(index);
    }

    @Override
    public void edit(int id, Student student) {
        int index = findIndexById(id);
        this.students.set(index, student);
    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }
}
