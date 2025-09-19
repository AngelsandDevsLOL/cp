package CCC.Senior;

import java.util.Scanner;

public class ASimulationProblem {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = (long) n * (n - 1) / 2;
        System.out.println(bsearch((long)(Math.ceil(x / (2.0))), n));
    }
    public static int bsearch (long n, int m) {
        int high = m;
        int low = 1;
        long x = (long) m * (m - 1) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            long num = (long) (m - mid) * (m - mid - 1) / 2;
            if (x - num >= n) {
                high = mid - 1;
            } else if (x - num < n) {
                low = mid + 1;
            }
        }
        return low;
    }
}
