package LA1Q1;
public class Node<T> {
    private T element;
    private Node<T> next;
    public Node() {}
    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
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
