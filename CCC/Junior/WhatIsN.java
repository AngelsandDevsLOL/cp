package CCC.Junior;

import java.util.Scanner;

public class WhatIsN {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int n = scanner.nextInt();
        count = 0;
        for (int i = 0; i < Math.min(6, n); i++) {
            if (n - i <= 5) {
                count++;
            }
            if (n - i == i || n - i == i + 1) {
                break;
            }
        }
        System.out.println(count);
    }
}
