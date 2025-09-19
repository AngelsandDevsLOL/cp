package COCI;

import java.util.Scanner;

public class Uzastopni {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        int num = (int) (input / 2 + 1);
        long[] sum = new long[num + 2];
        for (int i = 1; i <= num; i++) {
            sum[i] = sum[i-1] + i;
        }

    }
}
