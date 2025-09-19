package NoContest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class LongestBalancedSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int[] psa = new int[n + 2];
        fill(psa, input);
        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int l = sc.nextInt(), r = sc.nextInt();
                System.out.println((psa[r] - psa[l - 1]) * 2);
            } else {
                int p = sc.nextInt();
                if (input.charAt(p - 1) == '(') {
                    input = input.substring(0,p-1) + ")" + input.substring(p);
                } else {
                    input = input.substring(0,p-1) + "(" + input.substring(p);
                }
                fill(psa, input);
            }
        }
    }
    public static void fill (int[] psa, String input) {
        Stack s = new Stack();
        Arrays.fill(psa, 0);
        for (int i = 1; i <= input.length(); i++) {
            if (input.charAt(i - 1) == ')' && !s.isEmpty() && s.peek().equals("(")) {
                s.pop();
                psa[i]++;
            } else {
                s.add(input.substring(i-1,i));
            }
        }
        for (int i = 1; i < psa.length; i++) {
            psa[i] += psa[i-1];
        }
    }
}
