package AlphaStar;

import java.util.Scanner;

public class SayCarrot {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {-1, 1, 2, 4, 7, 8, 11, 13, 14};
        int n = sc.nextInt();
        System.out.println(15 * (n / 8) + a[n % 8]);
    }
}
