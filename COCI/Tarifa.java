package COCI;

import java.util.Scanner;

public class Tarifa {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = x * n + x;
        for (int i = 0; i < n; i++) {
            sum = sum - scanner.nextInt();
        }
        System.out.println(sum);
    }
}
