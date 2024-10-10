package Exercise_1_Stack_Data_Structure;

public class Node<T> {
    private T datum;
    private Node<T> next;
    public Node(){
        datum=null;
        next= null;
    }
    public Node(T datum, Node<T> next){
        this.datum=datum;
        this.next = next;
    }
    public T getDatum(){
        return datum;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setDatum(T datum){
        this.datum = datum;
    }
    public void setNext(Node<T> n){
        next = n;
    }
} // end of Node class
