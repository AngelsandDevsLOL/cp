package AtCOder;

import java.util.Scanner;

public class SmoothNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long two = 0;
        long three = 0;
        while (n % 2 == 0) {
            two++;
            n /= 2;
        }
        while (n % 3 == 0) {
            three++;
            n /= 3;
        }
        if (n != 1) System.out.println("No");
        else System.out.println("Yes");
    }
}
