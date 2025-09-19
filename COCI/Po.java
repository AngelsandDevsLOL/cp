package COCI;

import java.util.Scanner;
import java.util.Stack;

public class Po {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        Stack<Integer> s = new Stack<>();
        s.add(0);
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (s.peek() > input) {
                while (s.peek() > input) {
                    count++;
                    s.pop();
                }
                if (s.peek() < (input)) s.add(input);
            } else if (s.peek() < input) {
                s.add(input);
            }
        }
        if (s.peek() > 0) {
            while (s.peek() > 0) {
                count++;
                s.pop();
            }
        }
        System.out.println(count);
    }
}
