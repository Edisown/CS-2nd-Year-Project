/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim;
public interface MyLinkedList<E> {

    void addToHead(E data);
    void addToTail(E data);
    int getSize();
    void remove(E data);
    boolean isDeleted(E data);
}
