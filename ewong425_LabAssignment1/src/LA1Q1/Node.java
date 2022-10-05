package LA1Q1;
public class Node<T> {
    private T element;
    private Node<T> next;
    public Node() {}
    public Node(T t, Node<T> n) {
        element = t;
        next = n;
    }
    public Node<T> getNext() {
        return next;
    }
    public T getElement() {
        return element;
    }
    public void setNext(Node<T> n) {
        next = n;
    }
}
