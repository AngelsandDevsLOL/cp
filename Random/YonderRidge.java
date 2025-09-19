package Random;

import java.util.Scanner;

public class YonderRidge {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt(), k = sc.nextInt();
        int[][] ar = new int[n][3];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), v = sc.nextInt();
            ar[i][0] = a; ar[i][1] = b; ar[i][2] = v;
        }
        for (int i = 0; i < q; i++) {
            int p = sc.nextInt() - 1, s = sc.nextInt();
            double l = s * (ar[p][1] - ar[p][0])/(m * 1.0) + ar[p][0]; // not dividing the slope bc lazy (also m is constant)
            double r = (s + k) * (ar[p][1] - ar[p][0])/(m * 1.0) + ar[p][0];
            int count = 0;
            for (int j = 0; j < n; j++) {
                double l2 = s * (ar[j][1] - ar[j][0])/(m * 1.0) + ar[j][0]; // not dividing the slope bc lazy (also m is constant)
                double r2 = (s + k) * (ar[j][1] - ar[j][0])/(m * 1.0) + ar[j][0];
                if (l2 > l || r2 > r) {
                    count += ar[j][2];
                }
            }
            System.out.println(count);
        }
    }
}
