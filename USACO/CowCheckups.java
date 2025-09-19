package USACO;

import java.util.Scanner;

public class CowCheckups {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] psa = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            a[i] = input;
        }
        int[] b = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            b[i] = input;
            psa[i + 1] = psa[i] + (a[i] == b[i] ? 1 : 0);
            if (i == n - 1) {
                ans += psa[i + 1] * n * (n - 1) / 2;
            } else ans += psa[i + 1] * ((n - 2 * i - 2));
        }
        int[][] wants = new int[n + 1][2];
        int prev = (a[1] == b[1] ? 1 : 0);
        ans += (a[0] == b[0] ? 1 : 0) + (a[1] == b[1] ? 1 : 0) + (a[0] == b[1] ? 1 : 0) + (a[1] == b[0] ? 1 : 0);
        for (int i = 2; i < n; i++) {
            wants[b[i - 2]][1]++;
            wants[a[i - 2]][0]++;
            if (a[i] == b[i]) prev++;
            prev += wants[a[i]][1] + wants[b[i]][0];
            prev += (a[i - 1] == b[i] ? 1 : 0) + (a[i] == b[i - 1] ? 1 : 0);
            ans += prev;
        }
        ans += (a[n - 1] == b[n - 2] ? 1 : 0) + (a[n - 2] == b[n - 1] ? 1 : 0);
        System.out.println(ans);
    }
}
