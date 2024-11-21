package midtermlabproject2;

public interface PostfixInterface<E> {
    void push(E data);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
