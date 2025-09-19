package USACO;

import java.util.Scanner;

public class HaybaleFeast {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            int f = sc.nextInt(), s = sc.nextInt();
            input[i][0] = f;
            input[i][1] = s;
        }
        System.out.println(bSearch(0, (int) 1e9, input, m));
    }
    public static long bSearch (int low, int high, int[][] input, long flavour) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            long num = check(mid, input);
            if (num < flavour) {
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    public static long check (int spicyness, int[][] input) {
        long ans = 0; // max
        long current = 0;
        boolean working = false;
        for (int i = 0; i < input.length; i++) {
            if (input[i][1] <= spicyness) {
                if (working) {
                    current += input[i][0];
                } else {
                    working = true;
                    current = input[i][0];
                }
            } else {
                ans = Math.max(ans, current);
                current = 0;
            }
        }
        return Math.max(ans, current);
    }
}
