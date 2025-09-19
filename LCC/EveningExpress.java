package LCC;

import java.util.Scanner;
import java.util.Stack;

public class EveningExpress {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                int input = scanner.nextInt();
                if (!stack.isEmpty()) {
                    int x = stack.peek();
                    if (x == input) {
                        do {
                            stack.pop();
                            if (!stack.isEmpty()) {
                                x = stack.peek();
                            }
                            stack.push(++input);
                            if (!stack.isEmpty()&& x== input) {
                                stack.pop();
                            }
                        } while (!stack.isEmpty()&& x== input);
                    } else {
                        stack.push(input);
                    }
                } else {
                    stack.push(input);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }
            String[] value2 = String.valueOf(sb).trim().split(" ");
            sb = new StringBuilder();
            for (int j = value2.length-1; j >= 0; j--) {
                sb.append(value2[j] + " ");
            }
            String value = sb.toString().trim();
            scanner.nextLine();
            String aaron = scanner.nextLine();
            if (value.equals(aaron)) {
                System.out.println("VALID");
            } else {
                System.out.println("INVALID");

            }        }
    }
}
