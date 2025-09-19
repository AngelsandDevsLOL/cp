package CCC.Senior;

import java.util.ArrayList;
import java.util.Scanner;

public class LunchConcert {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] ar = new long[n][3];
        int min = 200000;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt(), speed = sc.nextInt(), dis = sc.nextInt();
            ar[i][0] = pos; ar[i][1] = speed; ar[i][2] = dis;
            min = Math.min(min, pos);
            max = Math.max(max, pos);
        }
        int low = min, high = max, mid = (low + high) / 2;
        long ans = Long.MAX_VALUE;
        while (low <= high){
            mid = (low + high) / 2;
            long num1 = sum(mid - 1, ar), num2 = sum(mid + 1, ar);
            long num = sum(mid, ar);
            ans = Math.min(ans, num);
            if (num1 < num2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
    public static long sum (int x, long[][] ar) {
        long sum = 0;
        for (int i = 0; i < ar.length; i++) {
            long dif = Math.abs(ar[i][0] - x);
            sum += Math.max(dif - ar[i][2], 0) * ar[i][1];
        }
        return sum;
    }
}
