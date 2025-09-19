package AlphaStar;

import java.util.Arrays;
import java.util.Scanner;

public class TradingCards {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt();
        int[] ar = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ar[i] = sc.nextInt();
        }
        Arrays.sort(ar);
        System.out.println(bsearch(1, n, ar, k, l));
    }
    public static int bsearch (int low, int high, int[] ar, int k, int l) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(ar, mid, k, l)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean check (int[] ar, int r, int k, int l) {
        int maxDif = r - ar[ar.length - r];
        if (maxDif > k) return false;
        long sum = 0;
        for (int i = ar.length - r; i < ar.length && ar[i] < r; i++) {
            sum += r - ar[i];
            if (sum > (long)k * l) return false;
        }
        return true;
    }
}
