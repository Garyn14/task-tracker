package roadmap.tast_tracker.cli.repository;

import org.springframework.stereotype.Repository;
import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.exception.NotFoundTaskException;
import roadmap.tast_tracker.cli.model.Task;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository{

    private final List<Task> tasks;

    public TaskRepositoryImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Task creteTask(String description) {
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
    public Task updateTask(Task task) {
        Task updatedTask = this.getTaskById(task.getId());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());

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
