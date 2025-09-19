package USACO;

import java.util.Scanner;

public class CircularBarn {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int smallest = Integer.MAX_VALUE;
            boolean win = true;
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                int x = (input - 1) / 4 + 1;
                if (x < smallest) {
                    smallest = x;
                    if (input % 4 == 0) win = false;
                }
            }
            if (win) {
                System.out.println("Farmer John");
            } else {
                System.out.println("Farmer Nhoj");
            }
        }
    }
}
