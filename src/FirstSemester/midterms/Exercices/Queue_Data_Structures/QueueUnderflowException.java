package SecondYear.SecondSem.Midterms;

/**
 * Exception thrown when attempting to perform an operation on an empty queue.
 */
public class QueueUnderflowException extends RuntimeException {

    /**
     * Constructs a new QueueUnderflowException with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception
     */
    public QueueUnderflowException(String message) {
        super(message);
    }
}
