package SecondYear.SecondSem.Midterms;

/**
 * A node in a linked list for use in the Queue data structure.
 *
 * @param <T> the type of data held in this node
 */
public class QueueNode<T> {
    private T data;
    private QueueNode<T> next;
    /**
     * Constructs a QueueNode with the specified data and next node.
     *
     * @param data the data to be stored in this node
     * @param next the next node in the queue
     */
    public QueueNode(T data, QueueNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the data held by this node.
     *
     * @return the data of this node
     */
    public T getData() {
        return data; // Return the stored data
    }

    /**
     * Sets the data for this node.
     *
     * @param data the new data to be stored in this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the next node in the queue.
     *
     * @return the next QueueNode
     */
    public QueueNode<T> getNext() {
        return next;
    }

    /**
     * Sets the next node for this node.
     *
     * @param next the next QueueNode to be linked
     */
    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}
