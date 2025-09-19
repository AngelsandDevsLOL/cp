package LCC;

import java.util.Arrays;
import java.util.Scanner;

public class QualLeafIcations {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        Arrays.sort(ar);
        int cur = 0;
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] <= cur) {
                cur++;
            } else { // if ar[i] = 5,
                count += ar[i] - cur;
                cur = ar[i] + 1;
            }
        }
        System.out.println(count);
    }
}
