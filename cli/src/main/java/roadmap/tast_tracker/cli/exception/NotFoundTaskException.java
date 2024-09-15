package roadmap.tast_tracker.cli.exception;

public class NotFoundTaskException extends RuntimeException{
    public NotFoundTaskException(Long id) {
        super("ERROR: Task with id " + id + " not found");
    }
}
