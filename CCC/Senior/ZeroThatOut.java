package CCC.Senior;

import java.util.Scanner;
import java.util.Stack;

public class ZeroThatOut {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < k; i++) {
            int input = scanner.nextInt();
            if (input == 0){
                stack.pop();
            } else
                stack.push(input);
        }
        int sum = 0;
        final int size = stack.size();
        for (int i = 0; i < size; i++) {
            sum = sum + stack.peek();
            stack.pop();
        }
        System.out.println(sum);
    }
}
