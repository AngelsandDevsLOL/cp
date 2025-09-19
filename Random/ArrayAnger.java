package Random;

import java.util.Scanner;

public class ArrayAnger {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] psa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            psa[i] = psa[i - 1] + sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String[] input = sc.nextLine().split(" ");
            int l = Integer.parseInt(input[1]); int s = Integer.parseInt(input[2]);
            System.out.println(binarySearch(l - 1, n - 1, s, psa, psa[l - 1]));
        }
    }
    public static int binarySearch(int low, int high, int find, int[] arr, int num) { // find equal or above
        int ans = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] - num == find) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] - num > find) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
