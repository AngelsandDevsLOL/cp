package COCI;

import java.util.Scanner;

public class Dobri {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] ar = new boolean[600000];
        int[] in = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            in[i] = a;
            for (int j = 0; j < i; j++) {
                if (ar[a - in[j] + 300000]) {count++;break;
                }
            }
            for (int j = 0; j <= i; j++) {
                ar[a + in[j] + 300000] = true;
            }
        }
        System.out.println(count);
    }
}
