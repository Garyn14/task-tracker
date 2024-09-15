package roadmap.tast_tracker.cli.repository;

import org.springframework.stereotype.Repository;
import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.exception.NotFoundTaskException;
import roadmap.tast_tracker.cli.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    private final List<Task> tasks;

    public TaskRepositoryImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Task createdTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        return task;
    }

    @Override
    public Task getTaskById(Long id) {
        return this.tasks
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundTaskException(id));
    }

    @Override
    public Task updateTaskDescription(Long id, String description) {
        Task updatedTask = this.getTaskById(id);
        updatedTask.setDescription(description);
        updatedTask.setUpdatedAt(LocalDateTime.now());

        return updatedTask;
    }

    @Override
    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task updatedTask = this.getTaskById(id);
        updatedTask.setStatus(status);
        updatedTask.setUpdatedAt(LocalDateTime.now());

        return updatedTask;
    }

    @Override
    public void deleteTask(Long id) {
        Task task = this.getTaskById(id);
        tasks.remove(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return tasks
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .toList();
    }
}
