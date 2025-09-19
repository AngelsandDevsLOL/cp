package AlphaStar;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LemonadeLine {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i < n; i++) {
            cows[i] = -sc.nextInt();
        }
        Arrays.sort(cows);
        int i = 0;
        for (; i < n; i++) {
            if (-cows[i] < i) break;
        }
        System.out.println(i);
    }
}
