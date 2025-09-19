package YetAnotherContest;

import java.util.Scanner;

public class SecretSequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ar = new int[5];

        int n = sc.nextInt();
        int[] pxa = new int[n + 1];
        if (n == 3) {
            System.out.println("? 1 3");
            System.out.flush();
            int a = sc.nextInt();
            System.out.println("? 1 2");
            System.out.flush();
            int b = sc.nextInt();
            System.out.println("? 2 3");
            System.out.flush();
            int c = sc.nextInt();
            System.out.println("! " + (a ^ c) + " " + (a ^ b ^ c) + " " + (a ^ b));
        }
        else {
            System.out.println("? 1 " + n);
            System.out.flush();
            int t = sc.nextInt();
            int first = t;
            for (int i = 1; i <= Math.ceil((n - 1) / 2.0); i++) {
                System.out.println("? " + (i + 1) + " " + n);
                System.out.flush();
                int second = sc.nextInt();
                pxa[i] = first ^ second ^ pxa[i - 1];
                first = second;
            }
            for (int i = (int) Math.floor((n + 1) / 2.0); i < n; i++) {
                System.out.println("? 1 " + i);
                System.out.flush();
                int second = sc.nextInt();
                pxa[i] = second;
            }
            pxa[n] = pxa[n - 1] ^ t;
            System.out.print("!");
            for (int i = 1; i <= n; i++) {
                System.out.print(" " + (pxa[i] ^ pxa[i - 1]));
            }
            System.out.println();
        }
    }
}
