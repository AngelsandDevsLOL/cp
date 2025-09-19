package COCI;

import java.util.Scanner;
import java.util.Stack;

public class Eksplozjia {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String explosion = sc.nextLine();
        Stack<Pair> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (s.isEmpty() || s.peek().y == -1) {
                if (input.charAt(i) == explosion.charAt(0)) {
                    s.push(new Pair(input.charAt(i), 0));
                } else {
                    s.push(new Pair(input.charAt(i), -1));
                }
            } else {
                int prev = s.peek().y;
                if (input.charAt(i) == explosion.charAt(prev + 1)) {
                    s.push(new Pair(input.charAt(i), prev + 1));
                } else if (input.charAt(i) == explosion.charAt(0)) {
                    s.push(new Pair(input.charAt(i), 0));
                } else {
                    s.push(new Pair(input.charAt(i), -1));
                }
            }
            if (s.peek().y == explosion.length() - 1) {
                for (int j = 0; j < explosion.length(); j++) {
                    s.pop();
                }
            }
        }
        if (s.isEmpty()) System.out.print("FRULA");
        else {
            method(s);
        }
        System.out.println();
    }
    public static void method(Stack<Pair> s) {
        if (s.isEmpty()) return;
        char c = s.pop().x;
        method(s);
        System.out.print(c);
    }
    public static class Pair {
        char x;
        int y;
        public Pair(char x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
