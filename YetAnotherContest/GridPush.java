package YetAnotherContest;

import java.util.Scanner;

public class GridPush {
    public static int ans = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        recursion(1, n - 1, n);
        System.out.println(ans);
    }
    public static void recursion (int num, int cur, int n){
        if (num == n || cur == 0) {
            if (cur != 0) return;
            ans++;
            return;
        }
        for (int i = 0; i <= cur; i++) {
            recursion(num + 1, cur - i, n);
        }
    }
}
