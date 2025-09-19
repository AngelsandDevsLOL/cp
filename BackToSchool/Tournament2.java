package BackToSchool;

import java.util.Scanner;

public class Tournament2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] vis = new boolean[n + 1];
        long[] ans = new long[2 * n + 1];
        int[] val = new int[2 * n + 1];
        for (int i = 1; i < n; i++) {
            int input = sc.nextInt();
            val[i + n] = input;
            vis[input] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) val[n] = i;
        }
        for (int i = n - 1; i >= 1; i--) {
            val[i] = Math.max(val[i * 2], val[i * 2 + 1]);
            ans[i] = ans[i * 2] + ans[i * 2 + 1] + (long)(val[i * 2] - val[i * 2 + 1])*(val[i * 2] - val[i * 2 + 1]);
        }
        System.out.print(ans[1] + " ");
        for (int i = 0; i < n - 1; i++) {
            int temp = val[i + n];
            val[i + n] = val[i + n + 1];
            val[i + n + 1] = temp;
            update((i + n) / 2, val, ans);
            if ((i + n + 1) / 2 != (i + n) / 2) update((i + n + 1) / 2, val, ans);
            System.out.print(ans[1] + " ");
        }
        System.out.println();
    }
    public static void update (int cur, int[] val, long[] ans) {
        int newVal = Math.max(val[cur * 2], val[cur * 2 + 1]);
        val[cur] = newVal;
        long newAns = ans[cur * 2] + ans[cur * 2 + 1] + (long)(val[cur * 2] - val[cur * 2 + 1])*(val[cur * 2] - val[cur * 2 + 1]);
        ans[cur] = newAns;
        if (cur == 1) return;
        update(cur / 2, val, ans);
    }
}
