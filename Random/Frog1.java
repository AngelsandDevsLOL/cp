package Random;

import java.util.Arrays;
import java.util.Scanner;

public class Frog1 {
    public static int[] memo;
    public static int[] dis;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dis = new int[n];
        memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            dis[i] = h;
        }
        method(n - 1);
        System.out.println(memo[n - 1]);
    }
    public static void method(int x) {
        if (memo[x] != -1) return;
        if (memo[x - 1] == -1) method(x-1);
        if (x - 2 >= 0) {
            memo[x] = Math.min(memo[x - 1] + Math.abs(dis[x] - dis[x-1]), memo[x-2] + Math.abs(dis[x] - dis[x-2]));
        } else {
            memo[x] = memo[x-1] + Math.abs(dis[x] - dis[x-1]);
        }
    }
}