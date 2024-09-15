package roadmap.tast_tracker.cli.repository;

import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.model.Task;

import java.util.List;

public interface TaskRepository {
    Task creteTask(String description);
    Task getTaskById(Long id);
    Task updateTask(Task task);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
}
