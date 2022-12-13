package hw09.task1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YevhenKovalevskyi
 */
@NoArgsConstructor
@Data
public class StudentDto {
    
    private Integer id;
    private String name;
    private GroupStudentDto group;
}
