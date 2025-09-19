package AlphaStar;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TriangularBarns {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] psa = new int[(int)1e6 + 2];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            psa[a]++;
            psa[b + 1]--;
        }
        boolean bool = psa[0] != 0;
        int cur = 0;
        float ans = 0;
        for (int i = 1; i < psa.length; i++) {
            psa[i] += psa[i - 1];
            if (psa[i] >= 1 && !bool) {
                bool = true;
                cur = i;
            } else if (psa[i] == 0 && bool) {
                bool = false;
                ans += (i - cur - 1);
            }
        }
        System.out.format("%.3f", ans * Math.sqrt(2));
    }
}
