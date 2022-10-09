package LA1Q1;
public class Node<T> {
    //declare variables
    private T element;
    private Node<T> next;
    public Node() {}
    //constructor for nodes
    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }
    //returns the next node (this is the pointer)
    public Node<T> getNext() {
        return next;
    }
    //returns the element at a node
    public T getElement() {
        return element; //return the element of the nodes
    }
    //sets the next node, (where the pointer points to)
    public void setNext(Node<T> n) {
        next = n;
    }
}
