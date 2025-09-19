package Random;

import java.util.Scanner;

public class CheckerboardSummationEasy {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] ar = new int[m + 2][n + 2];
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        while (x != 0) {
            ar[x + 1][y + 1] = z;
            x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
        }
        for (int i = 2; i < m + 2; i++) {
            for (int j = 2; j < n + 2; j++) {
                ar[i][j] += ar[i][j - 2] + ar[i - 2][j] - ar[i - 2][j - 2];
            }
        }
        x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
        int num = sc.nextInt();
        while (x != 0) {
            int corner1 = ar[z + 1][num + 1] + ar[x][y] - ar[x][num + 1] - ar[z + 1][y];
            int corner2 = ar[z][num] + ar[x - 1][y - 1] - ar[x - 1][num] - ar[z][y - 1];
            int corner3 = ar[z][num + 1] + ar[x - 1][y] - ar[x - 1][num + 1] - ar[z][y];
            int corner4 = ar[z + 1][num] + ar[x][y - 1] - ar[x][num] - ar[z + 1][y - 1];
            if (x <= z - 1) {
                corner1 -= corner4;
            }
            if (y <= num - 1) {
                corner1 -= corner3;
            }
            if (x <= z - 1 && y <= num - 1) corner1 += corner2;
            if ((z - x) % 2 == 1) corner1 *= -1;
            System.out.println(corner1);
            x = sc.nextInt(); y = sc.nextInt(); z = sc.nextInt();
            num = sc.nextInt();
        }
    }
}
