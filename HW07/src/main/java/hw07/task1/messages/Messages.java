package hw07.task1.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Messages Enum represents text messages for use and localization(if it needed)
 */
@AllArgsConstructor
public enum Messages {
    START_PROGRAM("Start of the program...", "\nStart of the program...\n\n----------"),
    END_PROGRAM("End of the program.\n", "----------\n\nEnd of the program.\n"),
    
    TEACHER_NOT_FOUND("Teacher ID[{}] not found!", "Teacher ID[%s] not found!"),
    GROUP_NOT_FOUND("Group ID[{}] not found!", "Group ID[%s] not found!"),
    STUDENT_NOT_FOUND("Student ID[{}] not found!", "Student ID[%s] not found!"),
    
    ;
    
    @Getter private final String logMessage;
    @Getter private final String outMessage;
}
