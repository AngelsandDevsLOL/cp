package USACO;

import java.util.Scanner;

public class PaintingTheBarn {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] ar = new int[1002][1002];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            ar[x1][y1]++;
            ar[x2+1][y2+1]++;
            ar[x1][y2+1]--;
            ar[x2+1][y1]--;
        }
        for (int i = 1; i < 1000; i++) {
            ar[0][i] += ar[0][i - 1];
            ar[i][0] += ar[i - 1][0];
        }
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                ar[i][j] += ar[i][j - 1] + ar[i - 1][j] - ar[i-1][j-1];
                if (ar[i][j] == k) count++;
            }
        }
        System.out.println(count);
    }
}
