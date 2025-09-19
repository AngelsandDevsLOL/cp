package AlphaStar;

import java.util.Scanner;

public class RectangularHoel {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), b = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < 1 << (n + 1); i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i | (1 << j)) == i) sum += ar[j];
            }
            if (sum >= b) ans = Math.min(ans, sum);
        }
        System.out.println(ans - b);
    }
}
