package DMOPC;

import java.util.Scanner;

public class ShoeShopping {

    public static double[] memo;
    public static double[] items;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        memo = new double[x + 1];
        items = new double[x + 1];
        for (int i = 1; i <= x; i++) {
            items[i] = sc.nextDouble();
        }
        recursion(x);
        String str = String.valueOf(memo[x]);
        System.out.println(str.substring(0,str.indexOf(".") + 2));
    }
    public static void recursion(int x) {
        if (x >= 2) recursion(x - 1);
        if (x == 1) {
            memo[1] = items[1];
        } else if (x == 2) {
            memo[2] = items[1] + items[2] - Math.min(items[1], items[2]) / 2;
            memo[2] = Math.min(memo[2], memo[1] + items[2]);
        } else {
            memo[x] = memo[x - 2] + items[x - 1] + items[x] - Math.min(items[x-1], items[x]) / 2;
            memo[x] = Math.min(memo[x], memo[x - 1] + items[x]);
            memo[x] = Math.min(memo[x], memo[x - 3] + items[x - 2] + items[x - 1] + items[x] - (Math.min(Math.min(items[x - 1], items[x]), items[x - 2])));
        }
    }
}
