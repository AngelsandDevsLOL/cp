package AlphaStar;

import java.util.Arrays;
import java.util.Scanner;

public class CarrotGiving {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), b = sc.nextInt();
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt(), s = sc.nextInt();
            ar[i][0] = p + s;
            ar[i][1] = p / 2;
        }
        Arrays.sort(ar, (x, y) -> Integer.compare(x[0], y[0]));
        int sum = 0;
        int maxOff = 0;
        int ind = 0;
        while (ind < n && sum + ar[ind][0] <= b) {
            sum += ar[ind][0];
            maxOff = Math.max(maxOff, ar[ind][1]);
            ind++;
        }
        // if price taken off current,
        int leftOver = b - sum + maxOff;
        int ind2 = ind;
        int sum2 = 0;
        while (ind2 < n && sum2 + ar[ind2][0] <= leftOver) {
            ind2++;
            sum2 += ar[ind2][0];
        }
        // ans = ind2
        // if price is taken off future one,
        leftOver = b - sum;
        if (ind < n && ar[ind][0] - ar[ind][1] <= leftOver) ind++;
        System.out.println(Math.max(ind, ind2));
    }
}
