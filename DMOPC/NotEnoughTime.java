package DMOPC;

import java.util.Scanner;

public class NotEnoughTime {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt();
        int[] knapsack = new int[t + 1];
        for (int i = 0; i < n; i++) {
            int p1 = sc.nextInt();
            int v1 = sc.nextInt();
            int p2 = sc.nextInt();
            int v2 = sc.nextInt();
            int p3 = sc.nextInt();
            int v3 = sc.nextInt();
            for (int j = t; j >= 1; j--) {
                if (j >= p1) {
                    knapsack[j] = Math.max(knapsack[j], knapsack[j - p1] + v1);
                }
                if (j >= p2) {
                    knapsack[j] = Math.max(knapsack[j], knapsack[j - p2] + v2);
                }
                if (j >= p3) {
                    knapsack[j] = Math.max(knapsack[j], knapsack[j - p3] + v3);
                }
            }
        }
        System.out.println(knapsack[t]);
    }
}
