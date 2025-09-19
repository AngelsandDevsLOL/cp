package Random;

import java.util.Scanner;

public class TopBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        if (c == 2) {
            for (int i = 0; i < r - c; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(".");
                }
                System.out.println();
            }
            System.out.println(".E");
            System.out.println("S.");
        } else {
            for (int i = 0; i < r - c + 1; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(".");
                }
                System.out.println();
            }
            int point = 1;
            for (int i = 0; i < c - 3; i++) {
                for (int j = 0; j < c - point - 1; j++) {
                    System.out.print(".");
                }
                System.out.print("#");
                for (int j = 0; j < point; j++) {
                    System.out.print(".");
                }
                System.out.println();
                point++;
            }
            System.out.print(".#");
            for (int i = 0; i < c - 3; i++) {
                System.out.print(".");
            }
            System.out.println("E");
            System.out.print("S");
            for (int i = 0; i < c - 1; i++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}