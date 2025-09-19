package COCI;

import java.util.Scanner;

public class Rijeci {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = 1;
        int b = 0;
        for (int i = 0; i < k; i++) {
            int c = b;
            b += a;
            a = c;
        }
        System.out.println(a + " " + b);
    }
}
