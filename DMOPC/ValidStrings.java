package DMOPC;

import java.util.Scanner;
import java.util.Stack;

public class ValidStrings {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            boolean bool = true;
            String input = scanner.nextLine();
            String empty = ""; // could also use a StringBuilder
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(' || input.charAt(j) == ')'){
                    empty = empty + input.charAt(j);
                }
            }
            Stack<String> stack = new Stack();
            for (int j = 0; j < empty.length(); j++) {
                if (empty.charAt(j) == '(') {
                    stack.push("(");
                } else if ((stack.empty())) {
                    bool = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (bool && stack.isEmpty()){
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }
}
