package COCI;

import java.util.Arrays;
import java.util.Scanner;

public class Eko {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n+1];
        for (int i = 0; i < n; i++) {
            array[i+1] = scanner.nextInt();
        }
        Arrays.sort(array);
        int x = 0;
        int number = 0;
        boolean bool = false;
        int logs = 0;
        while (logs < m) {
            int difference = array[n-x] - array[n - x - 1];
            if (logs + (difference * (x+1)) >= m && !bool) {
                for (int i = 1; i <= difference; i++) {
                    if (logs + (i * (x+1)) >= m) {
                        logs = logs + (difference * (x+1));
                        number = array[n-x] - i;
                        bool = true;
                        break;
                    }
                }
            } else {
                logs = logs + (difference * (x+1));
                x++;
            }
        }
        System.out.println(number);
    }
}
