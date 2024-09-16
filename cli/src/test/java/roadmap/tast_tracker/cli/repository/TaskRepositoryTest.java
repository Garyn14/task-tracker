package roadmap.tast_tracker.cli.repository;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import roadmap.tast_tracker.cli.enums.TaskStatus;
import roadmap.tast_tracker.cli.model.Task;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryTest {

    @Nested
    class Happypath {
        // Creating a task with a valid description
        @Test
        void test_create_task_with_valid_description() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            String description = "New Task";
            Task task = taskRepository.createdTask(description);

            assertNotNull(task);
            assertEquals(description, task.getDescription());
            assertEquals(TaskStatus.TO_DO, task.getStatus());
            assertNotNull(task.getCreatedAt());
            assertNotNull(task.getUpdatedAt());
        }

        // Retrieving a task by a valid ID
        @Test
        void test_retrieving_task_by_valid_id() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            String description = "New Task";
            Task createdTask = taskRepository.createdTask(description);

            Task retrievedTask = taskRepository.getTaskById(createdTask.getId());

            assertNotNull(retrievedTask);
            assertEquals(description, retrievedTask.getDescription());
            assertEquals(TaskStatus.TO_DO, retrievedTask.getStatus());
            assertNotNull(retrievedTask.getCreatedAt());
            assertNotNull(retrievedTask.getUpdatedAt());
        }

        // Updating a task's description with a valid ID
        @Test
        void test_update_task_description_with_valid_id() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            String description = "Updated Description";
            Task task = taskRepository.createdTask("Initial Description");

            Task updatedTask = taskRepository.updateTaskDescription(task.getId(), description);

            assertNotNull(updatedTask);
            assertEquals(description, updatedTask.getDescription());
            assertNotNull(updatedTask.getUpdatedAt());
        }

        // Updating a task's status with a valid ID
        @Test
        void test_update_task_status_with_valid_id() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            Task task = taskRepository.createdTask("Task 1");
            Long taskId = task.getId();
            TaskStatus newStatus = TaskStatus.IN_PROGRESS;

            Task updatedTask = taskRepository.updateTaskStatus(taskId, newStatus);

            assertEquals(newStatus, updatedTask.getStatus());
            assertNotNull(updatedTask.getUpdatedAt());
        }

        // Deleting a task with a valid ID
        @Test
        void test_delete_task_with_valid_id() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            Task task = taskRepository.createdTask("Task to delete");
            Long taskId = task.getId();

            taskRepository.deleteTask(taskId);

            List<Task> tasks = taskRepository.getAllTasks();
            assertTrue(tasks.isEmpty());
        }

        // Retrieving all tasks
        @Test
        void test_retrieving_all_tasks() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            List<Task> tasks = new ArrayList<>();
            Task task1 = taskRepository.createdTask("Task 1");
            Task task2 = taskRepository.createdTask("Task 2");
            tasks.add(task1);
            tasks.add(task2);

            List<Task> retrievedTasks = taskRepository.getAllTasks();

            assertEquals(2, retrievedTasks.size());
            assertEquals(tasks, retrievedTasks);
            assertTrue(retrievedTasks.contains(task1));
            assertTrue(retrievedTasks.contains(task2));
        }

        // Retrieving tasks by a valid status
        @Test
        void test_retrieving_tasks_by_valid_status() {
            TaskRepository taskRepository = new TaskRepositoryImpl();
            Task task1 = taskRepository.createdTask("Task 1");
            Task task2 = taskRepository.createdTask("Task 2");
            Task task3 = taskRepository.createdTask("Task 3");

            task1.setStatus(TaskStatus.IN_PROGRESS);
            task2.setStatus(TaskStatus.TO_DO);
            task3.setStatus(TaskStatus.IN_PROGRESS);

            List<Task> inProgressTasks = taskRepository.getTasksByStatus(TaskStatus.IN_PROGRESS);

            assertEquals(2, inProgressTasks.size());
            assertTrue(inProgressTasks.contains(task1));
            assertTrue(inProgressTasks.contains(task3));
        }
    }
}