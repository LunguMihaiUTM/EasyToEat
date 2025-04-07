package agin.llc1.llc1.command;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

    public String executeCommand(Command command) {
        return command.execute();
    }
}
