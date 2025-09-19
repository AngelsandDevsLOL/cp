package MITIT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class NotSoLongIncreasingSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), k = sc.nextInt();
            Deque<Integer> d = new LinkedList<>();
            int[] ans = new int[k];
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if (!d.isEmpty() && d.peekLast() + k == input) d.pollLast();

            }
        }
    }
}
