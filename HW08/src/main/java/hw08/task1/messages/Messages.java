package hw08.task1.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Messages Enum represents text messages for use and localization(if it needed)
 */
@AllArgsConstructor
public enum Messages {
    START_PROGRAM("Start of the program...", "\nStart of the program...\n\n----------"),
    END_PROGRAM("End of the program.\n", "----------\n\nEnd of the program.\n"),
    
    SHOP_NOT_FOUND("Shop ID[{}] not found!", "Shop ID[%s] not found!"),
    EMPLOYEE_NOT_FOUND("Employee ID[{}] not found!", "Employee ID[%s] not found!"),
    REQUEST_ALREADY_TAKEN("Request already taken!", "Request already taken!"),
    
    ;
    
    @Getter private final String logMessage;
    @Getter private final String outMessage;
}