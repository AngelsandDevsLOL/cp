package School;

import java.util.Scanner;

public class MyList {
    int[] arr = new int[1]; // array instance variable to store the data
    int capacity; // instance variable (int field) to store the maximum number of elements allowed on the list
    int get(int index) { // return an element from the list at any given index
        return arr[index];
    }/*
    void insert(int element) { // insert an element at any index of the list

    }
    void remove() { // remove the first occurrence of any element from a non-empty list

    }
    void removeAt(int index) { // remove the element at a specified index from a non-empty list

    }
    void replace() { // replace an element at any index by another element

    }
    void size() { // return the number of elements in the list

    }
    boolean isEmpty() { // return true if the list is empty, otherwise return false

    }
    boolean isFull() { // return true if the list is full (based on the capacity instance variable), otherwise return false

    }*/
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        MyList ml = new MyList();
    }
}
