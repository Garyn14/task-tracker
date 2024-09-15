package roadmap.tast_tracker.cli.model;

import lombok.Getter;
import lombok.Setter;
import roadmap.tast_tracker.cli.enums.TaskStatus;

import java.time.LocalDateTime;

@Setter
@Getter
public class Task {
    private Long id;
    private static Long nextId = 0L;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        this.id = ++nextId;
        this.description = description;
        this.status = TaskStatus.TO_DO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
