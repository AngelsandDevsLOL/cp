package LCC;

import java.util.Arrays;
import java.util.Scanner;

public class MedicinalNuts {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        long[] ar = new long[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextLong();
        }
        Arrays.sort(ar);
        long num = 0;
        for (int i = 0; i < n; i++) {
            int x = binarySearch(ar, m - 1 - ar[i]);
            if (ar[i] + ar[x] < m) {
                num = Math.max(num, ar[i] + ar[x]);
            }
            else if (ar[i] < m) {
                num = Math.max(num, ar[i]);
            }
        }
        System.out.println(num);
    }
    static int binarySearch(long[] ar, long value) {
        int low = 0;
        int high = ar.length-1;
        int mid = (low + high) / 2;
        int ans = mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (ar[mid] == value) {
                return mid;
            } else if (ar[mid] > value) {
                high = mid - 1;
            } else { // ar[mid] < value
                low = mid + 1;
                ans = mid;
            }
            mid = (low + high) / 2;
        }
        return ans;
    }
}
