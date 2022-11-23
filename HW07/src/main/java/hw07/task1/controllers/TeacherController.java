package hw07.task1.controllers;

import hw07.task1.dto.*;
import hw07.task1.entities.Group;
import hw07.task1.entities.Teacher;
import hw07.task1.mappers.GroupMapper;
import hw07.task1.mappers.StudentMapper;
import hw07.task1.mappers.TeacherMapper;
import hw07.task1.services.TeacherService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YevhenKovalevskyi
 */
@AllArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {
    
    private TeacherService teacherService;
    
    /**
     * Create Teacher from FormData
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDto create(@RequestBody Teacher teacher) {
        return TeacherMapper.getForShow(teacherService.save(teacher));
    }
    
    /**
     * Update Teacher by ID from FormData
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto update(@PathVariable Integer id, @RequestBody Teacher teacher) {
        return TeacherMapper.getForShow(teacherService.save(id, teacher));
    }
    
    /**
     * Delete Teacher by ID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        teacherService.deleteById(id);
    }
    
    /**
     * Get all Teachers
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherDto> getAll() {
        return teacherService.findAll()
                .stream().map(TeacherMapper::getForShow).toList();
    }
    
    /**
     * Get Teacher by ID
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto getOne(@PathVariable Integer id) {
        return TeacherMapper.getForShow(teacherService.findById(id));
    }
    
    /**
     * Get Teacher Groups by ID
     */
    @GetMapping("/{id}/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupLightDto> getGroups(@PathVariable Integer id) {
        return teacherService.findById(id).getGroups()
                .stream().map(GroupMapper::getForShowSingle).toList();
    }
    
    /**
     * Get Teacher Groups count by ID
     */
    @GetMapping("/{id}/groups/count")
    @ResponseStatus(HttpStatus.OK)
    public int getGroupsCount(@PathVariable Integer id) {
        return teacherService.findById(id).getGroups().size();
    }
    
    /**
     * Get Teacher Students by ID
     */
    @GetMapping("/{id}/students")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentLightDto> getStudents(@PathVariable Integer id) {
        List<StudentLightDto> students = new ArrayList<>();
        
        for (Group group: teacherService.findById(id).getGroups()) {
            students.addAll(group.getStudents()
                    .stream().map(StudentMapper::getForShowSingle).toList());
        }
        
        return students;
    }
    
    /**
     * Get Teacher Students count by ID
     */
    @GetMapping("/{id}/students/count")
    @ResponseStatus(HttpStatus.OK)
    public int getStudentsCount(@PathVariable Integer id) {
        int students = 0;
        
        for (Group group: teacherService.findById(id).getGroups()) {
            students += group.getStudents().size();
        }
        
        return students;
    }
}
