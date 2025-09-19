package Arcadia;

import java.util.Scanner;

public class TestAnxiety {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), n = sc.nextInt();
        int b = (int) Math.floor(80 * (n + 1) - n * a);
        if (b <= 0) System.out.println(0);
        else if (b > 100) System.out.println(-1);
        else System.out.println(b);
    }
}
