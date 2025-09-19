package LCC;

import java.util.Scanner;

public class Conveyors {
    public static long mod = (long) 1e9 + 7;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int prime = 31;
        int n = sc.nextInt();
        long[] pow = new long[n + 1];
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        long num = 0;
        for (int i = 0; i < n; i++) {
            num *= prime;
            num += str2.charAt(i) - 'a';
            num %= mod;
        }
        long[] substring = new long[n + 1];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            substring[i] = substring[i - 1] * prime;
            substring[i] += str1.charAt(i - 1) - 'a';
            substring[i] %= mod;
            pow[i] = pow[i - 1] * prime;
            pow[i] %= mod;
        }
        int min = Integer.MAX_VALUE;
        if (substring[n] == num) min = 0;
        boolean direction = true; // right
        for (int i = 1; i < n; i++) {
            long temp = (substring[i] + ((substring[n] - substring[i] * pow[n - i] % mod + mod) * pow[i] % mod + mod)) % mod;
            if (temp == num) {
                if (i < min) {
                    min = i;
                    direction = true;
                }
                if (n - i < min) {
                    min = n - i;
                    direction = false;
                }
            }
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else {
            if (direction) System.out.println("L" + min);
            else System.out.println("R" + min);
        }
    }
}
