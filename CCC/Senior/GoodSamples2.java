package CCC.Senior;

import java.util.Scanner;

public class GoodSamples2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), m = sc.nextInt(), k = sc.nextLong();
        if (k < n) {
            System.out.println(-1); return;
        }
        k -= n;
        long max = 0;
        int cur = 1;
        int[] ans = new int[(int) n];
        for (int i = 0; i < n; i++) {
            if (k == 0) ans[i] = cur;
            else if (max != m - 1 && k > max){
                cur++;
                if (cur == m + 1) cur = 1;
                ans[i] = cur;
                k -= max;
                max++;
            } else if (max == m - 1 && k >= max) {
                cur++;
                if (cur == m + 1) cur = 1;
                ans[i] = cur;
                k -= max;
            } else {
                cur -= k;
                cur += m;
                if (cur % m == 0) cur = (int) m;
                else cur %= m;
                ans[i] = cur;
                k = 0;
            }
        }
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        } else System.out.println(-1);
    }
}
