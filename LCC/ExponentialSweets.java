package LCC;

import java.util.Scanner;

public class ExponentialSweets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        long choose = 1; // starts w/ (t choose t) => (t + 1 choose t)
        long ans = 0;
        int temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans += choose * ar[i];
            choose *= (t + temp);
            if (choose % temp != 0) {
                choose += 1e9 + 7;
            }
            choose /= temp;
            ans %= 1e9 + 7;
            choose %= 1e9 + 7;
            temp++;
        }
        System.out.println(ans);
    }
}