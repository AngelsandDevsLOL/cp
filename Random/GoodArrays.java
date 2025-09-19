package Random;

import java.util.Scanner;

public class GoodArrays {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n + 5];
        ar[1] = 1; ar[2] = 2;
        for (int i = 3; i < n + 5; i++) {
            ar[i] = ar[i - 1] + ar[i - 3] + 1;
            ar[i] %= 1e9 + 7;
        }
        System.out.println(ar[n]);
    }
}
