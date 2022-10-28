package hw02.task1;

import hw02.task1.messages.Messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The Main Class represents homework #2 #task1
 *
 * @author YevhenKovalevskyi
 */
@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info(Messages.START_PROGRAM.getLogMessage());
        System.out.println(Messages.START_PROGRAM.getOutMessage());
    
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("task1/applicationContext.xml");
        
        
        log.info(Messages.END_PROGRAM.getLogMessage());
        System.out.println(Messages.END_PROGRAM.getOutMessage());
    }
}
