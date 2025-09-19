package USACO;

import java.util.Scanner;

public class ConvolutedIntervals {
    public static void main  (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] x = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            x[i][0] = a;
            x[i][1] = b;
        }
        int[] ar = new int[2 * m + 2];
        for (int i = 0; i < n; i++) { // interval i
            for (int j = 0; j < n; j++) {// interval j
                if (x[j][1] + x[i][1] - x[i][0] - x[j][0] >=0) {
                    ar[x[i][0] + x[j][0]]++;
                    ar[x[j][1] + x[i][1] + 1]--;
                }
            }
        }
        System.out.println(ar[0]);
        for (int i = 1; i < 2 * m + 1; i++) {
            ar[i] = ar[i] + ar[i-1];
            System.out.println(ar[i]);
        }
    }
}
