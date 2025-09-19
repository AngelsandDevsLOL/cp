package WLMOJ;

import java.util.Scanner;

public class ChristmasDinner {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        System.out.println(a * (b) + (n - a) * c);
    }
}
