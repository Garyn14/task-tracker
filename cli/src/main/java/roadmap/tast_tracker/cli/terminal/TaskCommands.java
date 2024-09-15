package roadmap.tast_tracker.cli.terminal;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TaskCommands {
    @ShellMethod("Saluda a un usuario")
    public String saludar(String user){
        return "Hello " + user + "!!!";
    }
}
