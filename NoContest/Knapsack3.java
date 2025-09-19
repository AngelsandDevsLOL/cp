package NoContest;

import java.util.Scanner;

public class Knapsack3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long[] item = new long[(int) 1e7];
        for (int i = 0; i < n; i++) { // item
            long num = sc.nextLong(), vol = sc.nextLong(), prof = sc.nextLong();
            for (int j = 1; j <= num; j *= 2) {
                long v = vol * j, p = prof * j;
                for (int k = item.length - 1; k >= v; k--) item[k] = Math.max(item[k], item[(int) (k - v)] + p);
                num -= j;
            }
            if (num != 0) {
                long v = vol * num, p = prof * num;
                for (int k = item.length - 1; k >= v; k--) item[k] = Math.max(item[k], item[(int) (k - v)] + p);
            }
        }
        long largest = Long.MIN_VALUE;
        for (int i = 0; i < m; i++) { // truck
            int c = sc.nextInt(), f = sc.nextInt();
            largest = Math.max(largest, item[c] - f);
        }
        System.out.println(largest);
    }
}
