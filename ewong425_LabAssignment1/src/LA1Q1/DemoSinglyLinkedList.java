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
        numList.addFirst(intList.get(0));
        numList.addFirst(intList.get(1));
        numList.addFirst(intList.get(2));
        numList.addLast(intList.get(4));
        numList.addLast(intList.get(3));
        System.out.println("Your Integer list: " + numList.toString()); //return the Integer Linked List as a string
        //create a linked list for the Strings and store each string value in them from the ArrayList
        SinglyLinkList<String> nameList = new SinglyLinkList<>();
        nameList.addFirst(strList.get(0));
        nameList.addFirst(strList.get(1));
        nameList.addFirst(strList.get(2));
        nameList.addLast(strList.get(4));
        nameList.addLast(strList.get(3));
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
                System.out.println("The value " + num + " is found in location " + numList.searchStack(num) + " from the top of the stack.");
            } catch(IndexOutOfBoundsException e) { //catch any index out of bounds
                System.out.println("Index not found!");
            }
            System.out.println("\nDo you wish to continue? (enter y to continue or any other key to exit.)");
            cont = input.next().charAt(0); //ask if they would like to continue searching
        } while (cont == 'y');
        footer(1);
    }
    public static void stackDemo(SinglyLinkList linkedList) {
        int num = 0;
        SinglyLinkList<Integer> numList;
        numList = linkedList;
        System.out.println("Which end of the Linked List would you like to use as the top of the Stack?");
        do {
            try {
                System.out.println("Enter 1 for the Head or 2 for the Tail\n");
                num = input.nextInt();
                if(num == 1 || num == 2) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input! ");
            }
            input.next();
        } while(num != 1 || num != 2);
        if(num == 1) {
            System.out.println("Stack top: Head of the linked list.\n");
            System.out.println("Let's pop all the elements from the stack in the sequence: ");
            System.out.print("The current stack: " + numList.toString() + "\n");
            while (!numList.isEmpty()) {
                System.out.println(numList.popFromHead() + " has been popped! The revised stack: " + numList.toString());
            }
            System.out.println("\nLets push 39 and -58 in the stack");
            System.out.println("The currrent stack: " + numList.toString());
            numList.pushAtHead(39);
            System.out.println("After 39 is pushed, the revised stack is: " + numList.toString());
            numList.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack is: " + numList.toString());
        }
        if(num == 2) {
            System.out.println("Stack top: Tail of the linked list.");
            System.out.println("\nLet's pop the first three elements from the stack in sequence");
            System.out.print("The current stack: " + numList.toString() + "\n");
            for(int i=0; i<3; i++) {
                System.out.println(numList.popFromTail() + " has been popped! The revised stack: " + numList.toString());
            }
            System.out.println("\nLets push 39 and -58 in the stack");
            System.out.println("Current stack: " + numList.toString());
            numList.pushAtTail(39);
            System.out.println("After 39 is pushed, the revised stack: " + numList.toString());
            numList.pushAtTail(-58);
            System.out.println("After -58 is pushed, the revised stack: " + numList.toString());
        }
    }
    public static void queueDemo(SinglyLinkList linkedList) {
        SinglyLinkList<String> nameList;
        nameList = linkedList;
        System.out.println("Note: the Head is the front of the queue and the Tail is the end of the queue \n");
        System.out.println("Enqueue Joelle and Lukas in the queue in sequence... \n");

        System.out.println("The current queue is: " + nameList.toString());
        nameList.enqueueAtTail("Joelle");
        System.out.println("\nAfter Joeele is enqueued, the revised Queue: " + nameList.toString());
        nameList.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revised Queue: " + nameList.toString());

        System.out.println("\nLet's dequeue the first three elements from the queue in sequence... \n");
        System.out.println("The current queue is: " + nameList.toString());
        for(int i=0; i<2; i++) {
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
