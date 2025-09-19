package DMOPC;

import java.util.Scanner;
import java.util.Stack;

public class Balance {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        boolean bool = false;
        String input = "";
        for (int j = 0; j < sentence.length(); j++) {
            if (sentence.substring(j,j+1).equals("(") || sentence.substring(j,j+1).equals(")")){
                input = input + (sentence.substring(j,j+1));
            }
        }
        if (isBalanced(new StringBuilder(input))) {
            bool=true;
        }else {
            for (int i = 0; i < input.length(); i++) {
                StringBuilder string = new StringBuilder();
                if (input.substring(i, i + 1).equals("(")) {
                    string.append(input.substring(0, i) + ")" + input.substring(i + 1, input.length()));
                } else if (input.substring(i, i + 1).equals(")")) {
                    string.append(input.substring(0, i) + "(" + input.substring(i + 1, input.length()));
                }
                if (isBalanced(string)) {
                    bool = true;
                    break;
                }
            }
        }
        if (bool){
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
    public static boolean isBalanced(StringBuilder sb){
        int x = 0;
        Stack<String> stack = new Stack();
        boolean bool = true;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.substring(i,i+1).equals("(")) {
                stack.push(sb.substring(i, i + 1));
            } else if (sb.substring(i,i+1).equals(")") ){
                if (stack.size()>0 && stack.peek().equals("(")) {
                    stack.pop();
                } else{
                    bool = false;
                    break;
                }
            }
        }
        if (stack.size() !=0){
            bool = false;
        }
        return bool;
    }
}