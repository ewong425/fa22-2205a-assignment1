package LA1Q1;
public class SinglyLinkList<T> {
    //initialize variables
    private Node<T> head;
    private Node<T> tail;
    private int size;
    //constructor taking in a head and a tail node
    public SinglyLinkList(Node<T> head, Node<T> tail, int size) {
        //set local variables to the constructor ones
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
        if(isEmpty()) { //return empty brackets if the list is empty
            return "[]";
        }
        Node<T> pointer = new Node<>(); //create a pointer node which iterates through each node
        String s = ""; //create an empty string
        String formatted = s;
        pointer = head; //set the pointer = to the head node
        for(int i=0; i<size; i++) { //loop through the entire list and set the pointer = to each element and add it to the string
            if (i == size) {
                s+= pointer.getElement();
            }
            s += pointer.getElement() + ",";
            pointer = pointer.getNext();

        }
        formatted = String.format("[%s]",s);
        return formatted; //return the string
    }
    //add an element at the head of the list
    public void addFirst(T element) {
        head = new Node<>(element, head); //create a new node and have it point to the head node
        if (size == 0) { //if there are no nodes in the list, the tail and head point to the same node
          tail = head;
        }
        size ++; //increase the size of the list
    }
    //add an element at the tail of the element
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element, null); //create a new node with element and its pointer, the pointer is null since it is going to be our tail node
        if(isEmpty()) { //if the list is empty the new node is the only node in the list therefore it is the head node
            head = newNode;
        }
        else { //set the old tail to point at the new node
            tail.setNext(newNode);
            tail = newNode; //set tail equals to the new node
        }
        size++;
    }
    //remove the head node of the list
    public T removeFirst() {
        if (isEmpty())  //check if the list is empty if it is return null as there is no node to remove from the list
            return null;

        T answer = head.getElement(); //save the element of the head node in answer
        head = head.getNext(); //set head = to the next node in the list
        size--; //decrease the size of the node
        if (size == 0) //if decrease the size to zero, set tail equal to null
            tail = null;
        return answer;
    }
    //remove the tail node from the list
    public T removeLast() {
        if(isEmpty()) { //cannot remove a node when no node exists
            return null;
        }
        Node<T> pointer = new Node<>(); //pointer node
        pointer = head; //set the pointer = to the head node
        T answer = tail.getElement(); //save the element of the tail node to return
        for(int i=0; i<size-2; i++) { //loop until the second last node in the list
            pointer = pointer.getNext(); //set pointer = to the second last node in the list
        }
        pointer.setNext(null); //set pointer to point at null
        tail = pointer; //set tail equal to pointer
        size--; //decrease size of the list
        return answer; //return pointer
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
        int count = -1;
        for(int i=0; i<size; i++) {
            if(pointer.getElement().equals(element)){
                count = i+1;
            }
            if(pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
        }
        if(count == -1) {
            System.out.println("Value not found");
            return -1;
        } else {
            System.out.println("The value " + element + " is found in the location " + count + " from the top of the stack.");
            return count;
        }
    }
}

