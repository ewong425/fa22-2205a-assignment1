package LA1Q1;
public class SinglyLinkList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size;
    public SinglyLinkList(Node<T> h, Node<T> t, int s) {
        head  = h;
        tail = t;
        size = s;
    }
    public SinglyLinkList() {}

    public int getSize() {
        return size;
    }
    public Boolean isEmpty() {
        return size == 0;
    }
    public String toString() {

    }
    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (size == 0) {
          tail = head;
          size ++;
        }
    }
    public void addLast(T element) {
        Node<T> n = new Node<>(element, null);
        if(isEmpty()) {
            head = n;
        }
        else {
            tail.setNext(n);
        }
        size++;
    }
    public T removeFirst() {
        if (isEmpty())
            return null;

        T answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
    public T removeLast() {
        if (isEmpty())
            return null;
        T last = tail.getElement();
        tail =
    }
}

