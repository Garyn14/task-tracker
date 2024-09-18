package roadmap.tast_tracker.cli.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import roadmap.tast_tracker.cli.enums.TaskStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Nested
    class HappyPath {
        // Task object is created with a unique id
        @Test
        void test_task_creation_with_unique_id() {
            Task task1 = new Task("First task");
            Task task2 = new Task("Second task");

            assertNotEquals(task1.getId(), task2.getId());
        }

        // Task object is created with the correct description
        @Test
        void test_task_creation_with_correct_description() {
            Task task = new Task("Sample description");

            assertEquals("Sample description", task.getDescription());
        }

        // Task object is created with status set to TO_DO
        @Test
        void test_task_creation_with_status_to_do() {
            Task task = new Task("Sample task");
            assertEquals(TaskStatus.TO_DO, task.getStatus());
        }

        // Task object is created with current timestamps for createdAt and updatedAt
        @Test
        void test_task_creation_with_current_timestamps() {
            Task task = new Task("Test task");
            LocalDateTime currentDateTime = LocalDateTime.now();

            assertEquals(currentDateTime.toLocalDate(), task.getCreatedAt().toLocalDate());
            assertEquals(currentDateTime.toLocalDate(), task.getUpdatedAt().toLocalDate());
        }

        // toString method returns a correctly formatted string representation of the Task object
        @Test
        void test_toString_method_returns_correct_string_representation() {
            Task task = new Task("Sample task");

            String expected = "Task{id=" + task.getId() + ", description='Sample task', status=TO_DO, createdAt=" + task.getCreatedAt() + ", updatedAt=" + task.getUpdatedAt() + "}";
            String actual = task.toString();

            assertEquals(expected, actual);
        }
    }

    @Nested
    class EdgeCases {
        // Task object is created with an empty description
        @Test
        void test_task_creation_with_empty_description() {
            Task task = new Task("");

            assertEquals("", task.getDescription());
        }

        // Task object is created with a null description
        @Test
        void test_task_creation_with_null_description() {
            Task task = new Task(null);
            assertNull(task.getDescription());
        }

        // Multiple Task objects are created in quick succession to test unique id generation
        @Test
        void test_multiple_task_creation_unique_id() {
            Task task1 = new Task("Task 1");
            Task task2 = new Task("Task 2");
            Task task3 = new Task("Task 3");

            assertNotEquals(task1.getId(), task2.getId());
            assertNotEquals(task2.getId(), task3.getId());
            assertNotEquals(task1.getId(), task3.getId());
        }
    }
}