package BackToSchool;

import java.util.HashSet;
import java.util.Scanner;

public class Tournament {
    public static int num = 0;
    public static int[] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ar = new int[n - 1];
        HashSet<Integer> hMap = new HashSet();
        for (int i = 1; i <= n; i++) {
            hMap.add(i);
        }
        for (int i = 0; i < n - 1; i++) {
            ar[i] = sc.nextInt();
            hMap.remove(ar[i]);
        }
        for (int x : hMap) num = x;
        long[] ans = func(0, n - 2);
        for (int i = 0; i < ans.length; i += 2) {
            System.out.print(ans[i] + " " + ans[i] + " ");
        }
    }
    public static long[] func (int start, int end) {
        int size = end - start + 1;
        if (size == 2) {
            return new long[]{(ar[start] - ar[end]) * (ar[start] - ar[end]), Math.max(ar[start], ar[end])};
        } else if (size == 1) {
            return new long[]{(ar[start] - num) * (ar[start] - num), Math.max(ar[start], num)};
        }
        if (size % 2 == 0) { // EASYY
            long[] ar1 = func(start, start + size / 2 - 1); // [cur ans, value]
            long[] ar2 = func(start + size / 2, end);
            return new long[]{ar1[0] + ar2[0] + (ar1[1] - ar2[1]) * (ar1[1] - ar2[1]), Math.max(ar1[1], ar2[1])};
        } else {
            long[] ar1 = func(start, start + size / 2 - 1); // left first!
            long[] ar2 = func(start + size / 2, end); // [Pair] // [cur ans, value]

            long[] ar3 = func(start, start + size / 2);
            long[] ar4 = func(start + size / 2 + 1, end); // right next!

            long[] newAr = new long[ar1.length + ar4.length];
            for (int i = 0; i < ar1.length; i += 2) {
                newAr[i] = ar1[i] + ar2[0] + (ar1[i + 1] - ar2[1]) * (ar1[i + 1] - ar2[1]);
                newAr[i + 1] = Math.max(ar1[i + 1], ar2[1]);
            }
            for (int i = 0; i < ar4.length; i += 2) {
                newAr[i + ar1.length] = ar4[i] + ar3[0] + (ar4[i + 1] - ar3[1]) * (ar4[i + 1] - ar3[1]);
                newAr[i + 1 + ar1.length] = Math.max(ar4[i + 1], ar3[1]);
            }
            return newAr;
        }
    }
}
