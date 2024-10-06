/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim;
import java.util.NoSuchElementException;
public interface MyList<E> {
    public int getSize();
    public void insert(E data) throws ListOverflowException;
    public E getElement(int index) throws NoSuchElementException;
    public boolean delete(E data);
    public int search(E data);

}
