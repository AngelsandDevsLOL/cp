package EGOI;

import java.util.Arrays;
import java.util.Scanner;

public class DataCenters {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int[] ar1 = new int[n];
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            ar1[i] = -input;
        }
        Arrays.sort(ar1);
        for (int i = 0; i < s; i++) {
            int[] next = new int[n];
            int subtract = sc.nextInt(), num = sc.nextInt();
            int temp = num;
            for (int j = 0; j < num; j++) {
                ar1[j] += subtract;
            }
            int x = 0;
            for (int j = 0; j < n; j++) {
                if (num < n && ar1[num] <= ar1[x] || x == temp) {
                    next[j] = ar1[num++];
                } else {
                    next[j] = ar1[x++];
                }
            }
            ar1 = next;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(-ar1[i] + " ");
        }
        System.out.println();
    }
}
