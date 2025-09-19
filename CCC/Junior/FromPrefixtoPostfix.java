package CCC.Junior;

import java.util.Scanner;
import java.util.Stack;

public class FromPrefixtoPostfix {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("0")) {
            Stack<String> stack = new Stack<>();
            String[] ar = input.split(" ");
            for (int i = ar.length-1; i >= 0; i--) {
                if (ar[i].equals("+") || ar[i].equals("-")) {
                    String x = stack.pop();
                    String y = stack.pop();
                    stack.push(x + " " + y + " " + ar[i]);
                } else {
                    stack.push(ar[i]);
                }
            }
            System.out.println(stack.peek());
            input = scanner.nextLine();
        }
    }
}
