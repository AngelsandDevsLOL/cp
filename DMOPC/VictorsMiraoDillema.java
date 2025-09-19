package DMOPC;

import java.util.Scanner;

public class VictorsMiraoDillema {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[] psa = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int input = sc.nextInt();
            psa[i] = input + psa[i - 1];
        }
        int left = 0;
        int right = n;
        for (int i = 0; i < d; i++) {
            int input = sc.nextInt();
            int f = psa[input + left] - psa[left];
            int s = psa[right] - psa[input + left];
            if (f >= s) {
                System.out.println(f);
                left = input;
            } else {
                System.out.println(s);
                right = input;
            }
        }
    }
}
