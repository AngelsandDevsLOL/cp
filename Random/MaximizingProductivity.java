package Random;

import java.util.Arrays;
import java.util.Scanner;

public class MaximizingProductivity {
    public static int n;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); int q = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ar[i] -= sc.nextInt();
        }
        Arrays.sort(ar);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            System.out.println(n - bsearch(0, n - 1, ar, y) >= x ? "YES" : "NO");
        }
    }
    public static int bsearch (int low, int high, int[] ar, int find) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (find >= ar[mid]) { // {3} when you have a 10
                low = mid + 1;
            } else { // {11} when you have a 10
                high = mid - 1;
            }
        }
        return low;
    }
}
