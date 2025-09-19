package Random;

import java.util.Scanner;

public class Nightmare_a_thon {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n + 2], pmax = new int[n+2], pcount = new int[n+2], smax = new int[n+2], scount = new int[n+2];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            if (pmax[i-1] > a[i]) {
                pmax[i] = pmax[i - 1];
                pcount[i] = pcount[i - 1];
            }  else if (pmax[i-1] < a[i]) {
                pmax[i] = a[i];
                pcount[i] = 1;
            } else {
                pcount[i] = pcount[i-1] + 1;
                pmax[i] = pmax[i - 1];
            }
        }
        for (int i = n; i > 0; i--) {
            if (smax[i+1] > a[i]) {
                smax[i] = smax[i+1];
                scount[i] = scount[i+1];
            } else if (smax[i+1] < a[i]) {
                smax[i] = a[i];
                scount[i] = 1;
            } else {
                scount[i] = scount[i+1] + 1;
                smax[i] = smax[i + 1];
            }
        }
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int lmax = pmax[x-1];
            int lcount = pcount[x-1];
            int rmax = smax[y+1];
            int rcount = scount[y+1];
            if (lmax > rmax) System.out.println(lmax + " " + lcount);
            else if (rmax > lmax) System.out.println(rmax + " " + rcount);
            else System.out.println(lmax + " " + (rcount + lcount));
        }
    }
}