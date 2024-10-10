package Exercise_1_Stack_Data_Structure;

public class MyStack<T> implements MyStackInterface<T>{
    private Node<T> top;
    private int count;
    public MyStack(){
        top=null;
        count=0;
    }
    public void push(T item ){
        Node<T> newNode = new Node<T>(item, null);
        if (isEmpty()) {
            top = newNode;
        }

        else {
            newNode.setNext(top);
            top = newNode;
        }
        count +=1;
        return;
    }
    public T pop() throws StackUnderflowException{
        T topElement=null;
        if (isEmpty())
            throw new StackUnderflowException("Stack is empty");
        else {
            topElement = top.getDatum();
            if (count == 1) {
                top = null;
            } else {
                top = top.getNext();
            }
            count -= 1;
        }
        return topElement;
    }
    public T peek() throws StackUnderflowException {
        T topElement=null;
        if (isEmpty())
            throw new StackUnderflowException("Stack is empty");
        else {
            topElement = top.getDatum();
        }
        return topElement;
    }
    /* Make this method correct */
    public int size(){
        return count;
    }
    /* Make this method correct */
    public boolean isEmpty(){
        return count == 0;
    }
} // end of MyStack class
