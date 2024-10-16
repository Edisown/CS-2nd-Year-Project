package SecondYear.SecondSem.Midterms;

/**
 * An interface for a generic Queue data structure.
 *
 * @param <T> the type of elements held in this queue
 */
public interface QueueInterface<T> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param data the element to be added to the queue
     */
    public void enqueue(T data) throws QueueUnderflowException;

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public T dequeue() throws QueueUnderflowException;

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    public int size();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();
}
