package DMOPC;

import java.util.Scanner;
import java.util.Stack;

public class StringPuzzles {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String[] input = scanner.nextLine().split(" ");
            /*for (char j = 'a'; j < 'z'; j++) {
                String x = String.valueOf(j);
                while (input[0].contains(x + x)) {
                    char y = (char) (j + 1);
                    int index = input[0].lastIndexOf(x + x);
                    input[0] = input[0].substring(0,index) + y + input[0].substring(index+2);
                }
            }
            for (char j = 'a'; j < 'z'; j++) {
                String x = String.valueOf(j);
                while (input[1].contains(x + x)) {
                    char y = (char) (j + 1);
                    int index = input[1].lastIndexOf(x + x);
                    input[1] = input[1].substring(0,index) + y + input[1].substring(index+2);
                }
            }
            if (input[0].equals(input[1])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }*/
            Stack<String> stack = new Stack<>();
            Stack<String> stack2 = new Stack<>();
            for (int j = 0; j < input[0].length(); j++) {
                char x = input[0].charAt(j);
                recursion(stack, x);
            }
            for (int j = 0; j < input[1].length(); j++) {
                char x = input[1].charAt(j);
                recursion(stack2, x);
            }
            String string = "";
            String string2 = "";
            for (int j = 0; j < stack.size(); j++) {
                string = string + stack.pop();
            }
            for (int j = 0; j < stack2.size(); j++) {
                string2 = string2 + stack2.pop();
            }
            if (string.equals(string2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            //int num = Math.max(x, y, z);
            //int numm = Math.min(x, y, z);
        }
    }
    static void recursion (Stack<String> stack, char x) {
        if (!stack.isEmpty() && stack.peek().equals(String.valueOf(x))) {
            stack.pop();
            char character = (char) (x+ 1);
            recursion(stack, character);
        } else {
            stack.push(String.valueOf(x));
        }
    }
}
