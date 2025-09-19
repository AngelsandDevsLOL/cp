package CCC.MockS;

import java.util.Scanner;

public class Dupvoting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), u = sc.nextInt(), r1 = sc.nextInt(), r2 = sc.nextInt();
        int count = 0;
        for (int i = 1; i < u; i++) {
            for (int j = 1; j < u - i; j++) {
                int k = u - i - j;
                if (k <= 0) break;
                if (i + 2 * j - k == p) {
                    if (i * r2 == j * r1) count++;
                    else if (j * r2 == i * r1) count++;
                    else if (k * r2 == i * r1) count++;
                    else if (k * r2 == j * r1) count++;
                    else if (i * r2 == k * r1) count++;
                    else if (j * r2 == k * r1) count++;
                }
            }
        }
        System.out.println(count);
    }
}
