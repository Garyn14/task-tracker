package roadmap.tast_tracker.cli.terminal;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TaskCommands {
    @ShellMethod(key = "task-cli add", value = "add new task")
    public String addTask(String task){
        return "Task added successfully (ID: #)";
    }

    @ShellMethod(key = "task-cli update", value = "update a task by ID")
    public String updateTask(Long id, String task){
        return "Task updated successfully";
    }

    @ShellMethod(key = "task-cli delete", value = "delete a task by ID")
    public String deleteTask(Long id){
        return "Task deleted successfully";
    }

    @ShellMethod(key = "task-cli mark-to-do", value = "mark a task as to do by ID")
    public String makeTaskToDo(Long id){
        return "Task marked as to do successfully";
    }

    @ShellMethod(key = "task-cli mark-in-progress", value = "mark a task as in progress by ID")
    public String makeTaskInProgress(Long id){
        return "Task marked as in progress successfully";
    }

    @ShellMethod(key = "task-cli mark-done", value = "mark a task as done by ID")
    public String makeTaskDone(Long id){
        return "Task marked as done successfully";
    }

    @ShellMethod(key = "task-cli list", value = "list all tasks")
    public String listTasks(){
        return "Tasks listed successfully";
    }

    @ShellMethod(key = "task-cli list to-do", value = "list all to do tasks")
    public String listToDoTasks(){
        return "Todo tasks listed successfully";
    }

    @ShellMethod(key = "task-cli list in-progress", value = "list all in progress tasks")
    public String listInProgressTasks(){
        return "In progress tasks listed successfully";
    }

    @ShellMethod(key = "task-cli list done", value = "list all done tasks")
    public String listDoneTasks(){
        return "Done tasks listed successfully";
    }
}
