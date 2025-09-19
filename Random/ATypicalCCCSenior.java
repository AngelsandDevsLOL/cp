package Random;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class ATypicalCCCSenior {
    public static void main (String[] args) throws NoSuchElementException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            ar[i] = input;
        }
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            Stack<Integer> s = new Stack<>();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (ar[j] != i) {
                    s.add(ar[j]);
                    count += ar[j];
                } else {
                    for (int l = 0; l < num && !s.isEmpty(); l++) {
                        count -= s.pop();
                    }
                }
            }
            System.out.println(count);
        }
    }
}
