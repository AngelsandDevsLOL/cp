package USACO;

import java.util.Scanner;

public class CakeGame {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] cakes = new int[n];
            long totalSum = 0;
            long sliding = 0;
            for (int j = 0; j < n / 2 + 1; j++) {
                cakes[j] = sc.nextInt();
                totalSum += cakes[j];
                sliding += cakes[j];
            }
            long smallestBessie = sliding;
            for (int j = n / 2 + 1; j < n; j++) {
                cakes[j] = sc.nextInt();
                totalSum += cakes[j];
                sliding += cakes[j];
                sliding -= cakes[j - (n / 2 + 1)];
                smallestBessie = Math.min(smallestBessie, sliding);
            }

            System.out.println(smallestBessie +" " + (totalSum - smallestBessie));
        }
    }
}
