package Random;

import java.util.Scanner;

public class MaximumPermutationProduct {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        int first = ar[0], last = ar[n - 1];
        if (n == 1) System.out.println("1 1");
        else if (n == 3) {
            for (int i = 0; i < 3; i++) {
                if (ar[i] == 3) {
                    System.out.println(i + " " + i);
                    return;
                }
            }
        } else {
            if (first == 1) {
                System.out.println("2 " + n);
            } else if (last == 1) {
                System.out.println("1 " + (n - 1));
            } else {
                System.out.println("1 " + n);
            }
        }
    }
}
