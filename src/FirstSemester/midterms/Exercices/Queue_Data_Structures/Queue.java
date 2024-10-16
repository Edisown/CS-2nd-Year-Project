package SecondYear.SecondSem.Midterms;

public class Queue<T> implements QueueInterface<T> {
    private QueueNode<T> head; //first node in the queue
    private QueueNode<T> tail; //last node in the queue
    private int size;          // The number of elements in the queue

    /**
     * Constructor
     */
    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param data the element to be added to the queue
     */
    @Override
    public void enqueue(T data) throws QueueUnderflowException {
        QueueNode<T> newNode = new QueueNode<>(data, null);

        if (isEmpty()) {
            head = tail = newNode; // if the queue is empty, set head and tail to the new node
        } else {
            tail.setNext(newNode); // link the new node at the end of the queue
            tail = newNode;        // update the tail to the new node
        }
        size++; // increment the size of the queue
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            return null; // return null if the queue is empty
        }
        T data = head.getData(); // get the data from the head node
        head = head.getNext();    // move the head pointer to the next node
        if (head == null) {
            tail = null;          // reset the tail if the queue becomes empty
        }
        size--; // decrement the size of the queue
        return data; // return the data that was dequeued
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    @Override
    public int size() {
        return size; // return the size of the queue
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null; // return true if head is null, indicating the queue is empty
    }
}
