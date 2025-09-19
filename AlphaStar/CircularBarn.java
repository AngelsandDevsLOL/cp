package AlphaStar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CircularBarn {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        for (int i = 0; i < n && ar[i] != 0; i++) { // start
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < ar[i] - 1; j++) {
                q.add(i);
            }
            for (int j = 0; j < n; j++) {
               // int start =
            }
        }
    }
}
