package hw07.task1.dto;

import lombok.Data;

/**
 * @author YevhenKovalevskyi
 */
@Data
public class StudentDto {
    
    private Integer id;
    private String name;
    private GroupStudentDto group;
}
