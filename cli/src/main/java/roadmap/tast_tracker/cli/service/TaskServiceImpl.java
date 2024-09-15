package roadmap.tast_tracker.cli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.exception.NotFoundTaskException;
import roadmap.tast_tracker.cli.model.Task;
import roadmap.tast_tracker.cli.repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String addTask(String description) {
        Task task = taskRepository.createdTask(description);
        return "Task added successfully (ID: " + task.getId() + ")";
    }

    @Override
    public String updateTaskDescription(Long id, String description) {
        try {
            taskRepository.updateTaskDescription(id, description);
            return "Task description updated successfully";
        } catch (NotFoundTaskException e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateTaskStatus(Long id, TaskStatus status) {
        try {
            taskRepository.updateTaskStatus(id, status);
            return "Task status updated successfully";
        } catch (NotFoundTaskException e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteTask(Long id) {
        try {
            taskRepository.deleteTask(id);
            return "Task deleted successfully";
        } catch (NotFoundTaskException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }
}
