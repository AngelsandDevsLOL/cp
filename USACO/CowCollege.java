package USACO;

import java.util.Arrays;
import java.util.Scanner;

public class CowCollege {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tuition = new int[n];
        for (int i = 0; i < n; i++) {
            tuition[i] = scanner.nextInt();
        }
        Arrays.sort(tuition);
        long max = 0;
        long curr = 0;
        long cows = 0;
        for (int i = 0; i < n; i++) {
            curr = (long) tuition[i] * (n - i);
            if (curr > max) {
                max = curr;
                cows = tuition[i];
            }
        }
        System.out.println(max + " " + cows);
    }
}
