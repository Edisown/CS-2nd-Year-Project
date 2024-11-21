package midtermlabproject2;

public class MyStack<E> implements PostfixInterface<E>{
    private Node<E> top;
    private int count;

    public MyStack(){
        top = null;
        count = 0;
    }

    public void push(E data){
        Node<E> newNode = new Node<>(data, null);
        if (isEmpty()){
            top = newNode;
        }else{
            newNode.setNext(top);
            top = newNode;
        }
        count++;
    }

    public E pop(){
        E topElement;
        if (isEmpty()){
            throw new StackUnderflowException("Stack is empty");
        }else{
            topElement = top.getData();
            top = top.getNext();
        }
        count--;
        return topElement;
    }

    public E peek(){
        if (isEmpty()){
            throw new StackUnderflowException("Stack is emtpy");
        }
        return top.getData();
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public MyStack<E> copy(){
        MyStack<E> copy = new MyStack<>();
        MyStack<E> temp = new MyStack<>();

        while (!isEmpty()){
            temp.push(this.pop());
        }
        while (!temp.isEmpty()){
            E item = temp.pop();
            this.push(item);
            copy.push(item);
        }
        return copy;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyStack<E> copy = this.copy();
        MyStack<E> temp = new MyStack<>();

        // Move elements to a temporary stack
        while (!copy.isEmpty()) {
            E element = copy.pop();
            temp.push(element);
        }
        // Append elements from the temporary stack to the StringBuilder
        while (!temp.isEmpty()) {
            sb.append(temp.pop()).append(" ");
        }

        return sb.toString().trim();
    }
}
