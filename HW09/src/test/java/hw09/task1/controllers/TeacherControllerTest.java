package hw09.task1.controllers;

import hw09.task1.WatchmanExtension;
import hw09.task1.entities.Group;
import hw09.task1.entities.Student;
import hw09.task1.entities.Teacher;
import hw09.task1.exceptions.TeacherNotFoundException;
import hw09.task1.mappers.GroupMapper;
import hw09.task1.mappers.StudentMapper;
import hw09.task1.mappers.TeacherMapper;
import hw09.task1.services.TeacherService;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author YevhenKovalevskyi
 */
@Slf4j
@ExtendWith(WatchmanExtension.class)
@ExtendWith(MockitoExtension.class)
public class TeacherControllerTest {
    
    private static final Teacher TEACHER = new Teacher();
    private static final Group GROUP = new Group();
    private static final Student STUDENT = new Student();
    
    @Mock
    private TeacherService teacherService;
    
    @InjectMocks
    private TeacherController teacherController;
    
    @Test
    public void createReturnValidResponse() {
        when(teacherService.save(TEACHER)).thenReturn(TEACHER);
        assertEquals(TeacherMapper.getForShow(TEACHER), teacherController.create(TEACHER));
    }
    
    @Test
    public void updateReturnValidResponse() {
        when(teacherService.save(1, TEACHER)).thenReturn(TEACHER);
        assertEquals(TeacherMapper.getForShow(TEACHER), teacherController.update(1, TEACHER));
    }
    
    @Test
    public void updateReturnException() {
        when(teacherService.save(1, TEACHER)).thenThrow(TeacherNotFoundException.class);
        assertThatThrownBy(() -> teacherController.update(1, TEACHER))
                .isInstanceOf(TeacherNotFoundException.class);
    }
    
    //@Test
    public void deleteReturnValidResponse() {
        doNothing().when(teacherService).deleteById(1);
        
        //teacherController.delete(1);
        //verify(teacherService).deleteById(1);
    }
    
    //@Test
    public void deleteReturnException() {
        doNothing().when(teacherService).deleteById(1);
        
        //teacherController.delete(1);
        //verify(teacherService).deleteById(1);
    }
    
    @Test
    public void getAllReturnValidResponse() {
        when(teacherService.findAll()).thenReturn(Collections.singletonList(TEACHER));
        assertEquals(Stream.of(TEACHER).map(TeacherMapper::getForShow).toList(), teacherController.getAll());
    }

    @Test
    public void getOneReturnValidResponse() {
        when(teacherService.findById(1)).thenReturn(TEACHER);
        assertEquals(TeacherMapper.getForShow(TEACHER), teacherController.getOne(1));
    }
    
    @Test
    public void getOneReturnException() {
        when(teacherService.findById(1)).thenThrow(TeacherNotFoundException.class);
        assertThatThrownBy(() -> teacherController.getOne(1))
                .isInstanceOf(TeacherNotFoundException.class);
    }
    
    @Test
    public void getGroupsReturnValidResponse() {
        when(teacherService.findGroups(1)).thenReturn(Collections.singletonList(GROUP));
        assertEquals(Stream.of(GROUP).map(GroupMapper::getForShowSingle).toList(), teacherController.getGroups(1));
    }
    
    @Test
    public void getGroupsReturnException() {
        when(teacherService.findGroups(1)).thenThrow(TeacherNotFoundException.class);
        assertThatThrownBy(() -> teacherController.getGroups(1))
                .isInstanceOf(TeacherNotFoundException.class);
    }
    
    @Test
    public void getGroupsCountReturnValidResponse() {
        int count = anyInt();
        when(teacherService.findGroupsCount(1)).thenReturn(count);
        assertEquals(count, teacherController.getGroupsCount(1));
    }
    
    @Test
    public void getGroupsCountReturnException() {
        when(teacherService.findGroupsCount(1)).thenThrow(TeacherNotFoundException.class);
        assertThatThrownBy(() -> teacherController.getGroupsCount(1))
                .isInstanceOf(TeacherNotFoundException.class);
    }
    
    @Test
    public void getStudentsReturnValidResponse() {
        when(teacherService.findStudents(1)).thenReturn(Collections.singletonList(STUDENT));
        assertEquals(Stream.of(STUDENT).map(StudentMapper::getForShowSingle).toList(), teacherController.getStudents(1));
    }
    
    @Test
    public void getStudentsReturnException() {
        when(teacherService.findStudents(1)).thenThrow(TeacherNotFoundException.class);
        assertThatThrownBy(() -> teacherController.getStudents(1))
                .isInstanceOf(TeacherNotFoundException.class);
    }
    
    @Test
    public void getStudentsCountReturnValidResponse() {
        int count = anyInt();
        when(teacherService.findStudentsCount(1)).thenReturn(count);
        assertEquals(count, teacherController.getStudentsCount(1));
    }
    
    @Test
    public void getStudentsCountReturnException() {
        when(teacherService.findStudentsCount(1)).thenThrow(TeacherNotFoundException.class);
        assertThatThrownBy(() -> teacherController.getStudentsCount(1))
                .isInstanceOf(TeacherNotFoundException.class);
    }
}