package DMOPC;

import java.util.Arrays;
import java.util.Scanner;

public class DrHenriAndResponsibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] ar = new boolean[705 * n + 1];
        ar[0] = true;
        int total = 0;
        for (int i = 0; i < n; i++) {
            boolean[] temp = Arrays.copyOf(ar, ar.length);
            int a = sc.nextInt();
            total += a;
            for (int j = a; j < ar.length; j++) {
                temp[j] = ar[j - a];
            }
            for (int j = 0; j < temp.length; j++) {
                if (!ar[j]) ar[j] = temp[j];
            }
        }
        for (int i = 0; i <= Math.round(total / 2.0); i++) {
            if (ar[total / 2 - i]) {
                if (total % 2 == 0) {
                    System.out.println(i);
                } else System.out.println(i + 1);
                break;
            }
        }
    }
}