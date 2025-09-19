package CCC;

import java.util.Scanner;

public class BobsLightGame {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            array[l-1]++;
            if (r+1 <= n) {
                array[r]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                array[i] = array[i-1] + array[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
