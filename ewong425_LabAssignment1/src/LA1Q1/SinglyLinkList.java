package LA1Q1;
public class SinglyLinkList<T> {
    //initialize variables
    private Node<T> head;
    private Node<T> tail;
    private int size;
    //constructor taking in a head and a tail node
    public SinglyLinkList(Node<T> head, Node<T> tail, int size) {
        this.head  = head;
        this.tail = tail;
        this.size = size;
    }
    public SinglyLinkList() {}
    //returns size of the array
    public int getSize() {
        return size;
    }
    //check if list is empty
    public Boolean isEmpty() {
        return getSize() == 0;
    }
    //toString method which overides the java object
    @Override
    public String toString() {
        if(isEmpty()) {
            return "[]";
        }
        Node<T> pointer = new Node<>();
        String s = "";
        pointer = head;
        for(int i=0; i<size; i++) {
            s += pointer.getElement() + ", ";
            pointer = pointer.getNext();
        }
        return s;
    }
    //add an element at the head of the list
    public void addFirst(T element) {
        head = new Node<>(element, head);
        if (size == 0) {
          tail = head;
        }
        size ++;
    }
    //add an element at the tail of the element
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
    //remove the head node of the list
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
    //remove the tail node from the list
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
    //push a node at the head of the list like a stack
    public void pushAtHead(T element) {
        addFirst(element);
    }
    //pop a node from the head of the list like a stack
    public T popFromHead() {
        return removeFirst();
    }
    //push a node at the tail  of the list
    public void pushAtTail(T element) {
        addLast(element);
    }
    //pop a node at the tail of the list
    public T popFromTail() {
        return removeLast();
    }
    //enter the queue of a list by the tail
    public void enqueueAtTail(T element) {
        addLast(element);
    }
    //remove the head node of the list where head is the front of the queue
    public T dequeueAtHead() {
        return removeFirst();
    }
    //search the list for a desired element and return the index or node that it is at
    public int searchStack(T element) {
        Node<T> pointer;
        pointer = head;
        int count = 0;
        for(int i=0; i<size; i++) {
            if(pointer.getElement().equals(element)){
                count = i;
            }
            if(pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
        }
        if(count == 0) {
            System.out.println("Value not found");
            return 0;
        } else {
            return count;
        }
    }
}

