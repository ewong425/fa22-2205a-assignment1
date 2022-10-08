package LA1Q1;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class DemoSinglyLinkedList {
    Scanner input = new Scanner(System.in);
    char cont = 'y';
    public void main(String[] args) {
        //initialize variables
        int num = 0;
        //call header
        header(1);
        //create two ArrayLists 1 storing Integer values and the other storing String values
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(56,-22,34,57,98));
        ArrayList<String> strList = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));
        //Print out each arrayList
        System.out.println("\n" + intList);
        System.out.println("\n" + strList);
        //create a Linked List for the integers and store each integer value in them
        SinglyLinkList<Integer> numList = new SinglyLinkList<>();
        numList.addFirst(intList.get(0));
        numList.addFirst(intList.get(1));
        numList.addFirst(intList.get(2));
        numList.addLast(intList.get(4));
        numList.addLast(intList.get(3));
        numList.toString();
        SinglyLinkList<String> nameList = new SinglyLinkList<>();
        nameList.addFirst(strList.get(0));
        nameList.addFirst(strList.get(1));
        nameList.addFirst(strList.get(2));
        nameList.addLast(strList.get(4));
        nameList.addLast(strList.get(3));
        nameList.toString();
        System.out.println("Stack demo with the Integer linked list.. \n");
        stackDemo(numList);
        System.out.println("Queue demo with the String linked list.. \n");
        queueDemo(nameList);
        while(cont == 'y') {
            try {
                System.out.println("Let's search the stack");
                System.out.println("The current stack is: " + numList.toString());
                System.out.print("Enter the value you are searching for: ");
                num = input.nextInt();
            } catch(IndexOutOfBoundsException e) {
                System.out.println("Index not found! Do you wish to continue? (enter 'y' for yes and any other key to exit.");
            }
            numList.searchStack(num);
            cont = input.next().charAt(0);
        }
        footer(1);
    }
    public void stackDemo(SinglyLinkList linkedList) {
        int num = 0;
        while(num != 1 || num != 2) {
            try {
                System.out.println("Which end of the Linked List would you like to use as the top of the Stack?");
                System.out.println("Enter 1 for the Head or 2 for the Tail \n");
                num = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Incorrect Input, please enter 1 for the head or 2 for the tail");
            }
        }
    }
    public void queueDemo(SinglyLinkList linkedList) {

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
