package roadmap.tast_tracker.cli.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.model.Task;
import roadmap.tast_tracker.cli.service.TaskService;

import java.util.List;

@ShellComponent
public class TaskCommands {

    private final TaskService taskService;

    @Autowired
    public TaskCommands(TaskService taskService) {
        this.taskService = taskService;
    }

    @ShellMethod(key = "task-cli add", value = "add new task")
    public String addTask(String description){
        return taskService.addTask(description);
    }

    @ShellMethod(key = "task-cli update", value = "update a task by ID")
    public String updateTask(Long id, String description){
        return taskService.updateTaskDescription(id, description);
    }

    @ShellMethod(key = "task-cli delete", value = "delete a task by ID")
    public String deleteTask(Long id){
        return taskService.deleteTask(id);
    }

    @ShellMethod(key = "task-cli mark-to-do", value = "mark a task as to do by ID")
    public String makeTaskToDo(Long id){
        return taskService.updateTaskStatus(id, TaskStatus.TO_DO);
    }

    @ShellMethod(key = "task-cli mark-in-progress", value = "mark a task as in progress by ID")
    public String makeTaskInProgress(Long id){
        return taskService.updateTaskStatus(id, TaskStatus.IN_PROGRESS);
    }

    @ShellMethod(key = "task-cli mark-done", value = "mark a task as done by ID")
    public String makeTaskDone(Long id){
        return taskService.updateTaskStatus(id, TaskStatus.DONE);
    }

    @ShellMethod(key = "task-cli list", value = "list all tasks")
    public List<Task> listTasks(){
        return taskService.getAllTasks();
    }

    @ShellMethod(key = "task-cli list to-do", value = "list all to do tasks")
    public List<Task> listToDoTasks(){
        return taskService.getTasksByStatus(TaskStatus.TO_DO);
    }

    @ShellMethod(key = "task-cli list in-progress", value = "list all in progress tasks")
    public List<Task> listInProgressTasks(){
        return taskService.getTasksByStatus(TaskStatus.IN_PROGRESS);
    }

    @ShellMethod(key = "task-cli list done", value = "list all done tasks")
    public List<Task> listDoneTasks(){
        return taskService.getTasksByStatus(TaskStatus.DONE);
    }

    @ShellMethod(key = "task-cli download", value = "download all tasks")
    public String downloadTasks(){
        return taskService.downloadTasks();
    }
}
