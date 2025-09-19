package USACO;

import java.util.Scanner;

public class PalindromeGame {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            if (input.charAt(input.length() - 1) == '0') {
                System.out.println("E");
            } else {
                System.out.println("B");
            }
        }
    }
}
