package prelimproject2;

/**
 * The GoogleClassroomList class is a custom implementation of a singly linked list
 * for managing objects such as students, assignments, or announcements in Google Classroom.
 *
 * @param <E> The type of elements stored in the list.
 */
public class GoogleClassroomList<E> implements MyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /**
     * Adds a new element to the head of the list.
     *
     * @param data The data to be added.
     */
    @Override
    public void addToHead(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the tail of the list.
     *
     * @param data The data to be added.
     */
    @Override
    public void addToTail(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    /**
     * Removes an element from the list by matching its data.
     *
     * @param data The data of the element to be removed.
     */
    @Override
    public void remove(E data) {
        Node<E> current = head;
        Node<E> prevNode = null;

        if (head == null) {
            System.out.println("List is currently empty...");
            return;
        }

        if (head.getInfo().equals(data)) {
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return;
        }

        while (current != null && !current.getInfo().equals(data)) {
            prevNode = current;
            current = current.getNext();
        }

        if (current != null) {
            prevNode.setNext(current.getNext());
            if (current == tail) {
                tail = prevNode;
            }
        }
        size--;
    }

    /**
     * Returns the size of the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if an element has been deleted from the list.
     *
     * @param data The data to check for.
     * @return True if the data is no longer in the list, false otherwise.
     */
    @Override
    public boolean isDeleted(E data) {
        Node<E> current = head;
        while (current.getNext() != null) {
            if (current.getInfo().equals(data)) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /**
     * Displays all the elements in the list.
     */
    public void displayList() {
        if (head == null) {
            System.out.printf("%n%s%n%n", "List is empty...");
            return;
        }
        Node<E> current = head;
        int i = 1;
        while (current != null) {
            System.out.println(i + "." + current.getInfo().toString());
            current = current.getNext();
            i++;
        }
        System.out.println("\n\n");
    }

    /**
     * Retrieves an element by its index in the list.
     *
     * @param index The index of the element to retrieve.
     * @return The data of the element at the given index.
     */
    @Override
    public E get(int index) {
        Node<E> current = head;
        while (index < 0 || index >= size) {
            System.out.println("Please enter a valid choice...");
        }
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getInfo();
    }

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
