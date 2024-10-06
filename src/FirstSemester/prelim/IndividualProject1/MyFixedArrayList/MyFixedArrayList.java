/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim.MyFixedArrayList;

import prelim.ListOverflowException;
import prelim.MyList;

import java.util.NoSuchElementException;

/**
 * A fixed-size array list implementation.
 *
 * @param <E> The type of elements stored in this list.
 */
public class MyFixedArrayList<E> implements MyList<E> {
    private static final int maxSize = 5;
    private E[] elements;
    private int size;

    /**
     * Constructs an empty MyFixedArrayList with a fixed capacity.
     */
    public MyFixedArrayList() {
        elements = (E[]) new Object[maxSize];
        size = 0;
    }

    /**
     * Returns the current number of elements in the list.
     *
     * @return The size of the list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Inserts a new element into the list if there is space available.
     *
     * @param data The element to be inserted.
     * @throws ListOverflowException If the list is already full.
     */
    @Override
    public void insert(E data) throws ListOverflowException {
        if (size >= maxSize) {
            throw new ListOverflowException("The List is full");
        }
        elements[size++] = data;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws NoSuchElementException If the index is out of bounds.
     */
    @Override
    public E getElement(int index) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index out of bounds");
        }
        return elements[index];
    }

    /**
     * Deletes the first occurrence of the specified element from the list.
     *
     * @param data The element to be deleted.
     * @return true if the element was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(E data) {
        int index = search(data);
        if (index != -1) {
            // Shift elements to the left to fill the gap
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[--size] = null; // Remove the last element and decrease size
            return true;
        }
        return false;
    }

    /**
     * Searches for the first occurrence of the specified element in the list.
     *
     * @param data The element to search for.
     * @return The index of the first occurrence of the element, or -1 if the element is not found.
     */
    @Override
    public int search(E data) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return A string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
