package DMOPC;

import java.util.Scanner;

public class VictorsMoralDilemma {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] trolley = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            trolley[i] = scanner.nextInt();
            trolley[i] += trolley[i-1];
        }
        int min = 0;
        int max = n;
        for (int i = 0; i < d; i++) {
            int num = scanner.nextInt();
            long fsum = trolley[num + min] - trolley[min];
            long ssum = trolley[max] - trolley[num + min];
            if (fsum >= ssum) {
                System.out.println(fsum);
                min = num;
            } else {
                System.out.println(ssum);
                max = num;
            }
        }
    }
}
