package COCI;

import java.util.Scanner;
import java.util.Stack;

public class Esej {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Stack<Character> s = new Stack<>();
            for (int j = 0; j < input.length(); j++) {
                if (s.isEmpty() || s.peek() != input.charAt(j)) {
                    s.push(input.charAt(j));
                } else {
                    s.pop();
                }
            }
            if (s.size() == 0) sum++;
        }
        System.out.println(sum);
    }
}
