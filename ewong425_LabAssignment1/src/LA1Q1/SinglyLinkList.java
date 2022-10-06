package LA1Q1;
public class SinglyLinkList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size;
    public SinglyLinkList(Node<T> head, Node<T> tail, int size) {
        this.head  = head;
        this.tail = tail;
        this.size = size;
    }
    public SinglyLinkList() {}

    public int getSize() {
        return size;
    }
    public Boolean isEmpty() {
        return size == 0;
    }
    public String toString() {
        Node<T> pointer = new Node<>();
        String s = "";
        pointer = head;
        for(int i=0; i<size; i++) {
            pointer = pointer.getNext();
            s = "" + pointer.getElement();
        }
        return s;
    }
    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (size == 0) {
          tail = head;
        }
        size ++;
    }
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, null);
        if(isEmpty()) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
            tail = newNode;
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
        Node<T> pointer = new Node<>();
        pointer = head;
        T answer = tail.getElement();
        for(int i=0; i<size-2; i++) {
            pointer = pointer.getNext();
        }
        pointer.setNext(null);
        tail = pointer;
        size--;
        return answer;
    }
    public void pushAtHead(T element) {
        addFirst(element);
    }
}

