package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class BowlingForNumbers {
    public static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int r = 0; r < t; r++) {
            int n = sc.nextInt(), k = sc.nextInt(), w = sc.nextInt();
            int[] ar = new int[n];
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            int p1 = 0;
            arr[0] = ar[0];
            for (int i = 1; i < n; i++) {
                if (i - p1 < 3) {
                    arr[i] = ar[i] + arr[i - 1];
                }  else {
                    arr[i] = ar[i] + arr[i - 1] - ar[p1++];
                }
            }
            ar = Arrays.copyOf(arr, n);
            for (int i = 1; i < n; i++) {
                arr[i] = Math.max(arr[i], arr[i - 1]);
            }
            for (int i = 1; i < k; i++) {
                int[] temp = Arrays.copyOf(arr, n);
                for (int j = w; j < n; j++) {
                    arr[j] = Math.max(arr[j], temp[j - w] + ar[j]);
                }
                for (int a = w; a < n; a++) {
                    arr[a] = Math.max(arr[a], arr[a - 1]);
                }
            }
            System.out.println(arr[n - 1]);
        }
    }
}
