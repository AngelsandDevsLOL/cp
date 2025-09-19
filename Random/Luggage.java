package Random;

import java.util.Arrays;
import java.util.Scanner;

public class Luggage {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean bool = false;
            if (i != 0) {
                // get one below
                int x = array[i] - array[i-1];
                if (x <= k) {
                    bool = true;
                }
            }
            if (i != n - 1 && !bool) {
                int x = array[i+1] - array[i];
                if (x <= k) {
                    bool = true;
                }
            }
            if (bool) {
                count++;
            }
        }
        System.out.println(count);
    }
}
