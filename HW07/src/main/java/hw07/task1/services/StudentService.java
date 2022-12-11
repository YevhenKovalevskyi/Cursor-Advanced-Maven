package hw07.task1.services;

import hw07.task1.dto.StudentDto;
import hw07.task1.dto.StudentEditDto;

import java.util.List;

/**
 * @author YevhenKovalevskyi
 */
public interface StudentService {
    
    StudentDto create(StudentEditDto studentDto);
    StudentDto update(Integer id, StudentEditDto studentDto);
    void deleteById(Integer id);
    List<StudentDto> findAll();
    StudentDto findById(Integer id);
}
