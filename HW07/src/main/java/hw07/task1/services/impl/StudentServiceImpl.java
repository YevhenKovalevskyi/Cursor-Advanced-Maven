package hw07.task1.services.impl;

import hw07.task1.dto.StudentDto;
import hw07.task1.dto.StudentEditDto;
import hw07.task1.entities.Student;
import hw07.task1.exceptions.StudentNotFoundException;
import hw07.task1.mappers.StudentMapper;
import hw07.task1.messages.Messages;
import hw07.task1.services.StudentService;
import hw07.task1.repositories.StudentRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YevhenKovalevskyi
 */
@AllArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    
    public Student findByIdIfExists(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> {
            log.error(Messages.STUDENT_NOT_FOUND.getLogMessage(), id);
            throw new StudentNotFoundException(
                    String.format(Messages.STUDENT_NOT_FOUND.getOutMessage(), id)
            );
        });
    }
    
    public StudentDto create(StudentEditDto studentDto) {
        Student student = studentRepository.save(
                studentMapper.toCreateEntity(studentDto)
        );
    
        return studentMapper.toDto(student);
    }
    
    public StudentDto update(Integer id, StudentEditDto studentDto) {
        Student currentStudent = findByIdIfExists(id);
        Student updatedStudent = studentRepository.save(
                studentMapper.toUpdateEntity(currentStudent, studentDto)
        );
    
        return studentMapper.toDto(updatedStudent);
    }
    
    public void deleteById(Integer id) {
        findByIdIfExists(id);
        studentRepository.deleteById(id);
    }
    
    public List<StudentDto> findAll() {
        return ((List<Student>) studentRepository.findAll())
                .stream()
                .map(student -> studentMapper.toDto(student))
                .toList();
    }
    
    public StudentDto findById(Integer id) {
        return studentMapper.toDto(findByIdIfExists(id));
    }
}
