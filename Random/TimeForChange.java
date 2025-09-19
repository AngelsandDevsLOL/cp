package Random;

import java.util.Arrays;
import java.util.Scanner;

public class TimeForChange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int m = sc.nextInt(), n = sc.nextInt();
            int[] arr = new int[m+1];
            int[] ar = new int[n];
            Arrays.fill(arr, (int) 10e6); arr[0] = 0;
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
            }
            Arrays.sort(ar);
            for (int j = n - 1; j >= 0; j--) {
                for (int k = ar[j]; k < arr.length; k++) {
                    arr[k] = Math.min(arr[k - ar[j]] + 1, arr[k]);
                }
            }
            System.out.println(arr[m]);
        }
    }
}
