package USACO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class MilkSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sorted = new int[n];
        long[] psa = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sorted[i] = sc.nextInt();
        }
        long sum = 0;
        int[] index = Arrays.copyOf(sorted, n); // {1, 10, 4, 2, 6} = {0, 1, 2, 3, 4}
        Arrays.sort(sorted);
        for (int i = 1; i <= n; i++) {
            psa[i] = psa[i - 1] + sorted[i - 1];
            sum += (long) sorted[i - 1] * i;
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int newInsertion = binarySearch(sorted, b, 0, n - 1); // we are INCLUDING the old one
            int oldInsertion = binarySearch(sorted, index[a - 1], 0, n - 1);
            long curSum = sum - ((long) index[a - 1] * (oldInsertion + 1));
            if (newInsertion <= oldInsertion) { // insertion point is before (new number is smaller)
                curSum += (long) (newInsertion + 1) * b;
                curSum += psa[oldInsertion] - psa[newInsertion];
            } else { // insertion point is after (new number is bigger)
                curSum += (long) (newInsertion) * b;
                curSum -= psa[newInsertion] - psa[oldInsertion + 1];
            }
            System.out.println(curSum);
        }
    }
    public static int binarySearch (int[] ar, int find, int low, int high) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = ar[mid];
            if (val == find) {
                return mid;
            } else if (val > find) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans + 1;
    }
}
