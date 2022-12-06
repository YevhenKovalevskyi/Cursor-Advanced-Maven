package hw07.task1.services;

import hw07.task1.entities.Student;

import java.util.List;

/**
 * @author YevhenKovalevskyi
 */
public interface StudentService {
    
    Student create(Student student);
    Student update(Integer id, Student student);
    void deleteById(Integer id);
    List<Student> findAll();
    Student findById(Integer id);
}
