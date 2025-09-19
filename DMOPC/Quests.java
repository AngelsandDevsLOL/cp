package DMOPC;

import java.util.Scanner;

public class Quests {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), H = sc.nextInt();
        long[] memo = new long[H + 1];
        for (int i = 1; i <= N; i++) {
            long[] temp = new long[H + 1];
            int g = sc.nextInt(), h = sc.nextInt(), q = sc.nextInt(), t = sc.nextInt();
            for (int j = H; j >= h; j--) {
                temp[j] = memo[j - h] + g;
            }
            for (int j = h + t; j <= H; j++) {
                temp[j] = Math.max(temp[j - t] + q, temp[j]);
            }
            for (int j = 0; j <= H; j++) {
                temp[j] = Math.max(temp[j], memo[j]);
            }
            memo = temp;
        }
        System.out.println(memo[H]);
    }
}