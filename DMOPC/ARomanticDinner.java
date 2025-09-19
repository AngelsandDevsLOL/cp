package DMOPC;

import java.util.Arrays;
import java.util.Scanner;

public class ARomanticDinner {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), u = sc.nextInt(), r = sc.nextInt();
        int[][] dis = new int[u + 1][m + 1];
        for (int i = 0; i < r; i++) {
            int v = sc.nextInt(), t = sc.nextInt(), f = sc.nextInt();
            int[][] copy = Arrays.stream(dis).map(int[]::clone).toArray(int[][]::new);
            for (int j = f; j <= u; j++) {
                for (int k = t; k <= m; k++) {
                    copy[j][k] = Math.max(dis[j - f][k - t] + v, dis[j][k]);
                }
            }
            dis = copy;
        }
        int max = 0;
        for (int i = 0; i <= u; i++) {
            if (dis[i][m] > max) max = dis[i][m - 1];
        }
        System.out.println(max);
    }
}
