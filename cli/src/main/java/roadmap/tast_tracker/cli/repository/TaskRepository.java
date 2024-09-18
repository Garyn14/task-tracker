package roadmap.tast_tracker.cli.repository;

import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.model.Task;

import java.util.List;

public interface TaskRepository {
    Task createTask(String description);
    Task getTaskById(Long id);
    Task updateTaskDescription(Long id, String description);
    Task updateTaskStatus(Long id, TaskStatus status);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
}
