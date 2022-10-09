package LA1Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DemoSinglyLinkedList {
    static Scanner input = new Scanner(System.in);
    static  char cont = 'y';
    public static void main(String[] args) {
        //initialize variables
        int num = 0;
        //call header
        header(1);
        //create two ArrayLists 1 storing Integer values and the other storing String values
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(56,-22,34,57,98));
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));
        //Print out each arrayList
        System.out.println("The given Integer array: " + intList);
        System.out.println("The given String array: " + strList);
        //create a Linked List for the integers and store each integer value in them from the ArrayList
        SinglyLinkList<Integer> numList = new SinglyLinkList<>();
        //add the first three elements from the integer List to the head of the linked list
        for(int i=0; i<intList.size()-2; i++) {
            numList.addFirst(intList.get(i));
        }
        //add the last 2 elements from the integer List to the tail of the linked list
        for(int i=intList.size()-1; i>2; i--) {
            numList.addLast(intList.get(i));
        }
        System.out.println("Your Integer list: " + numList.toString()); //return the Integer Linked List as a string
        //create a linked list for the Strings and store each string value in them from the ArrayList
        SinglyLinkList<String> nameList = new SinglyLinkList<>();
        //add the first three elements from the name arrayList to the head linked list
        for(int i=0; i<strList.size()-2; i++) {
            nameList.addFirst(strList.get(i));
        }
        //add the last two elements from the name arrayList to the tail of the list
        for(int i=strList.size()-1; i>2; i--) {
            nameList.addLast(strList.get(i));
        }
        System.out.println("Your String list: " + nameList.toString() + "\n"); //return the String Linked List as a string
        //calling stackDemo to realize Linked List as a stack
        System.out.println("Stack demo with the Integer linked list..");
        stackDemo(numList);
        //calling queueDemo to realize Linked List as a queue
        System.out.println("\nQueue demo with the String linked list..");
        queueDemo(nameList);
        //Stack search section, while the input of the user is 'y'
        System.out.println("\nLet's search the stack");
        System.out.println("The current stack is: " + numList.toString());
        do {
            //take in the value that the user wishes to be found
            try {
                System.out.print("Enter the value you are searching for: ");
                num = input.nextInt();
                numList.searchStack(num);
            } catch(IndexOutOfBoundsException e) { //catch any index out of bounds
                System.out.println("Index not found!");
            }
            System.out.println("\nDo you wish to continue? (enter y to continue or any other key to exit.)");
            cont = input.next().charAt(0); //ask if they would like to continue searching
        } while (cont == 'y');
        footer(1);
    }
    public static void stackDemo(SinglyLinkList linkedList) {
        //intialize variables
        int num = 0;
        SinglyLinkList<Integer> numList;
        numList = linkedList;
        //ask user which side of the Linked list do they wish to be the top of the stack
        System.out.println("Which end of the Linked List would you like to use as the top of the Stack?");
        do {
            try {
                //make sure that they are inputting either 1 or 2
                System.out.println("Enter 1 for the Head or 2 for the Tail\n");
                num = input.nextInt();
                if(num == 1 || num == 2) {
                    break;
                }
                //catch any mismatched inputs
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input! ");
            }
            //clear scanner
            input.next();
        } while(num != 1 || num != 2);
        //num == 1 means head is the top of the stack
        if(num == 1) {
            System.out.println("Stack top: Head of the linked list.\n");
            System.out.println("Let's pop all the elements from the stack in the sequence: ");
            //pop all elements in the numList
            System.out.print("The current stack: " + numList.toString() + "\n\n");
            while (!numList.isEmpty()) {
                System.out.println(numList.popFromHead() + " has been popped! The revised stack: " + numList.toString());
            }
            //pushing 39 and -58 into the stack
            System.out.println("\nLets push 39 and -58 in the stack");
            System.out.println("The currrent stack: " + numList.toString()); //shows current stack
            numList.pushAtHead(39); //pushes at head 39
            System.out.println("After 39 is pushed, the revised stack is: " + numList.toString());
            numList.pushAtHead(-58); //pushes at head -58
            System.out.println("After -58 is pushed, the revised stack is: " + numList.toString());
        }
        //num==2 tail is the top of the stack
        if(num == 2) {
            System.out.println("Stack top: Tail of the linked list.");
            System.out.println("\nLet's pop the first three elements from the stack in sequence");
            System.out.print("The current stack: " + numList.toString() + "\n");
            for(int i=0; i<3; i++) { //pop three elements from the list
                System.out.println(numList.popFromTail() + " has been popped! The revised stack: " + numList.toString());
            }
            //push 39 and -58 into the stack
            System.out.println("\nLets push 39 and -58 in the stack");
            System.out.println("Current stack: " + numList.toString());
            numList.pushAtTail(39); //push at the tail 39
            System.out.println("After 39 is pushed, the revised stack: " + numList.toString());
            numList.pushAtTail(-58); //push at tail -58
            System.out.println("After -58 is pushed, the revised stack: " + numList.toString());
        }
    }
    public static void queueDemo(SinglyLinkList linkedList) {
        //initialize variables
        SinglyLinkList<String> nameList;
        nameList = linkedList;
        System.out.println("Note: the Head is the front of the queue and the Tail is the end of the queue \n");
        System.out.println("Enqueue Joelle and Lukas in the queue in sequence... \n");
        //printing the current string list
        System.out.println("The current queue is: " + nameList.toString());
        nameList.enqueueAtTail("Joelle"); //adding Joelle to the end of the queue with enqueue
        System.out.println("\nAfter Joeele is enqueued, the revised Queue: " + nameList.toString());
        nameList.enqueueAtTail("Lukas"); //adding Lukas to the end of the queue with enqueue
        System.out.println("After Lukas is enqueued, the revised Queue: " + nameList.toString());
        //removing three people from the queue using dequeue at head
        System.out.println("\nLet's dequeue the first three elements from the queue in sequence... \n");
        System.out.println("The current queue is: " + nameList.toString());
        for(int i=0; i<2; i++) { //three names are dequeued from the list
            System.out.println(nameList.dequeueAtHead() + " has been dequeued The revised queue: " + nameList.toString());
        }
    }
    public static void header(int n) {
        System.out.println("Lab Assignment: " + n);
        System.out.println("Prepared by: Ethan Wong");
        System.out.println("Student Number: 251205049");
        System.out.println("Goal: To realize Stacks and Queues using the Linked List data structure");
        System.out.println("=============================================\n");
    }
    public static void footer(int n) {
        int lab = n;
        System.out.println("=============================================");
        System.out.println("Completion of Lab Assignment " + n + " is successful!");
        System.out.println("Signing off -Ethan ");
    }
}
