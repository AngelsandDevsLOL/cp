package WLMOJ;

import java.util.Scanner;

public class PresentUnwrapping {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
        if (b <= a) System.out.println(-1);
        else System.out.println((long)Math.floor((b * k) / (b * 1.0 - a)) + 1);
    }
}
