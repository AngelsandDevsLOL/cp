package LCC;

import java.util.Scanner;

public class SkippersNutHunt {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] ar = new int[n];
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int count = 0;
        while (!vis[r]) {
            vis[r] = true;
            r = ar[r-1];
            count++;
        }
        System.out.println(count);
    }
}
