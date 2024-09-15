package roadmap.tast_tracker.cli.service;

import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.model.Task;

import java.util.List;

public interface TaskService {
    String addTask(String description);
    String updateTaskDescription(Long id, String description);
    String deleteTask(Long id);
    String updateTaskStatus(Long id, TaskStatus status);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
}
