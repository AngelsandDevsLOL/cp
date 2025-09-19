package LCC;

import java.util.*;

public class GrahamsNeighbourhood {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();
            int[][] ar = new int[n][2];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                ar[i][0] = a; ar[i][1] = b;
            }
            Arrays.sort(ar, (x, y) -> Integer.compare(x[0], y[0])); // lambda notation
            boolean temp = false;
            int saved = 0, maxv = 0, coord = 0;
            for (int[] pair : ar) {
                int a = pair[0];
                int b = pair[1];

                if (b != 1 && !temp) continue;
                else if (b == 1 && !temp) {
                    temp = true;
                    coord = a;
                } else if (b == 0) {
                    maxv = Math.max(maxv, a - coord);
                    coord = a;
                } else {
                    maxv = Math.max(maxv, a - coord);
                    saved += maxv;
                    maxv = 0;
                    coord = a;
                }
            }
            System.out.println(ar[n - 1][0] - ar[0][0] - saved);
        }
    }
}