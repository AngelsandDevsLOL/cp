package AlphaStar;

import java.util.Scanner;

public class PaintingTheBarn {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] ar = new int[1001][1001];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
            ar[x1][y1]++;
            ar[x2][y2]++;
            ar[x1][y2]--;
            ar[x2][y1]--;
        }
        int count = 0;
        for (int i = 1; i < 1001; i++) {
            ar[i][0] += ar[i - 1][0];
            ar[0][i] += ar[0][i - 1];
        }
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                ar[i][j] += ar[i - 1][j] + ar[i][j - 1] - ar[i - 1][j - 1];
            }
        }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (ar[i][j] == k)count++;
            }
        }
        System.out.println(count);
    }
}
