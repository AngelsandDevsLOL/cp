package Arcadia;

import java.util.Scanner;
import java.util.TreeSet;

public class CyclicSorting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            ar[i] = input;
        }
        TreeSet<Integer> tSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (ar[i] <= ar[(i + 1) % n]) {}
            else {
                tSet.add(i);
            }
        }
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt();
            if (tSet.contains(x)) {
                tSet.remove(x);
            }
            if (tSet.contains((x - 1 + n) % n)) tSet.remove((x - 1 + n) % n);

            ar[x] = y;
            if (ar[x] <= ar[(x + 1) % n]) { }
            else {
                tSet.add(x);
            }
            if (ar[((x - 1 + n) % n)] <= ar[x]) { }
            else {
                tSet.add(((x - 1 + n) % n));
            }

            if (tSet.size() == 1) {
                int ans = 0;
                for (int temp : tSet) ans = ((temp + 1) % n);
                System.out.println(Math.min(ans, n - ans));
            } else if (tSet.isEmpty()) System.out.println(0);
            else System.out.println(-1);
        }
    }
}
