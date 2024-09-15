package roadmap.tast_tracker.cli.repository;

import org.junit.jupiter.api.Test;
import roadmap.tast_tracker.cli.model.Task;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskRepositoryTest {
    @Test
    void test_create_task_with_valid_description() {
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
        String description = "Valid Task Description";

        Task task = taskRepository.creteTask(description);

        assertNotNull(task);
        assertEquals(description, task.getDescription());
        assertEquals(1, taskRepository.getAllTasks().size());
        assertEquals(task, taskRepository.getAllTasks().get(0));
    }
}