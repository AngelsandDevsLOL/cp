package Random;

import java.util.Scanner;

public class HeadDataSlaveApplications {
    public static void main (String[] args) {
        int mod = 1000000007;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            count += ar[i];
        }
        long[] factorial = new long[n + 2];
        factorial[0] = 1;
        for (int i = 1; i <= n + 1; i++) {
            factorial[i] = (i) * factorial[i - 1];
            factorial[i] %= mod;
        }
        long num = 1;
        for (int i = n - 1; i >= 0; i--) {
            long num2 = factorial[count - 2];
            long num3 = factorial[ar[i] - 1] * factorial[count - ar[i] + 1];
            num3 %= mod;
            num *= num2 * (count - 1) / num3;
            count -= ar[i];
            num %= mod;
        }
        System.out.println(num);
    }
}
