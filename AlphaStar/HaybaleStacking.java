package AlphaStar;

import java.util.Arrays;
import java.util.Scanner;

public class HaybaleStacking {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] ar = new int[n + 2];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            ar[x]++;
            ar[y + 1]--;
        }
        for (int i = 1; i < n + 2; i++) {
            ar[i] += ar[i - 1];
        }
        Arrays.sort(ar);
        System.out.println(ar[(n - 1) / 2 + 2]);
    }
}
