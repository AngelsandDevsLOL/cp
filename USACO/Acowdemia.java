package USACO;

import java.util.Arrays;
import java.util.Scanner;

public class Acowdemia {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = -1 * scanner.nextInt();
        }
        Arrays.sort(a);
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] * -1 >= h + 1) h++;
            else break;
        }
        for (int i = h; i >= Math.max(0, h-k+1); i--) {
            a[i]--;
        }
        Arrays.sort(a);
        h = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] * -1 >= h + 1) h++;
            else break;
        }
        System.out.println(h);
    }
}
