package AlphaStar;

import java.util.*;

public class StudentID {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] psa = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            psa[i] = (x + psa[i - 1]) % 7;
        }
        int[][] ar = new int[7][2];
        ar[0][0] = Integer.MAX_VALUE; ar[1][0] = Integer.MAX_VALUE; ar[2][0] = Integer.MAX_VALUE; ar[3][0] = Integer.MAX_VALUE; ar[4][0] = Integer.MAX_VALUE; ar[5][0] = Integer.MAX_VALUE; ar[6][0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ar[psa[i]][0] = Math.min(i, ar[psa[i]][0]);
            ar[psa[n - i]][1] = Math.max(n - i, ar[psa[n - i]][1]);
        }
        int max = 0;
        for (int i = 0; i < 7; i++) {
            if (ar[i][0] != Integer.MAX_VALUE && ar[i][1] != 0 && ar[i][1] - ar[i][0] >= 0) max = Math.max(ar[i][1] - ar[i][0], max);
        }
        if (max == 0 && (ar[0][0] != Integer.MAX_VALUE || ar[0][1] != 0)) {
            max = 1;
        }
        System.out.println(max);
    }
}
