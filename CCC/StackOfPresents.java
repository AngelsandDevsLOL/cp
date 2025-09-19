package CCC;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackOfPresents {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int length = 1;
        for (int i = 0; i < array.length; i++) {
            Stack<Integer> stack = new Stack();
            stack.push(array[i]);
            for (int j = i; j < array.length; j++) {
                //if ()
                for (int k = j; k < array.length; k++) {

                }
            }
        }
        System.out.println(length);
    }
    public static void balance(Stack stack){
        int size = 0;
        for (int i = 0; i < stack.size(); i++) {
            //int num = Integer.parseInt(stack);
            //size = size + stack.get(i);
            for (int j = i; j < stack.size(); j++) {

            }
        }
    }
}
