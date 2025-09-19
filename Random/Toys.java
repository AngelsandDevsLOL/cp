package Random;

import java.util.Scanner;
import java.util.TreeSet;

public class Toys {
    public static TreeSet[] dp;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new TreeSet[(int) Math.sqrt(n) + 1];
        TreeSet<Integer> ans = new TreeSet<>();
        ans.add(n - 1);
        for (int i = 2; i < dp.length; i++) {
            if (n % i == 0) {
                int num = n / i;
               // if (dp[i].isEmpty())
            }
        }
    }
}
