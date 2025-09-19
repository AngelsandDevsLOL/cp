package Random;

import java.util.Scanner;

public class WOSSCountingChristmasTrees {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int max = 1;
        int count = 1;
        int cur = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (cur < ar[i]) {
                cur = ar[i];
                count++;
            } else {
                cur = ar[i];
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
        max = 1;
        count = 1;
        cur = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (cur > ar[i]) {
                cur = ar[i];
                count++;
            } else {
                cur = ar[i];
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        System.out.println(max);
    }
}
