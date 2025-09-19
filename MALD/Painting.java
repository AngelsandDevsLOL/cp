package MALD;

import java.util.Scanner;

public class Painting {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double number = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int h = scanner.nextInt();
            int r = scanner.nextInt();
            double ink = Math.abs(((r*r) - (h * h)) * Math.PI / 10);
            number += ink;
        }
        int index = String.valueOf(number).indexOf(0);
        System.out.println(String.valueOf(number).substring(0, index + 7));
    }
}
