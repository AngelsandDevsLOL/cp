package CCC;

import java.util.Scanner;

public class ShiftySum {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        for (int i = 0; i <= k; i++) {
            int x = (int) Math.pow(10.0, Double.parseDouble(String.valueOf(i)));
            count = count + (n * x);
        }
        System.out.println(count);
    }
}
