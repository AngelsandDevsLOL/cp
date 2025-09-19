package DMOPC;

import java.util.Scanner;

public class CycleSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ar = new int[n][2];
        int ind1 = 0;
        int ind2 = 0;
        int[] ind = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ar[i][0] = sc.nextInt(); ar[i][1] = ar[i][0];
            ind[ar[i][0]] = i;
            if (ar[i][0] == 1) ind1 = i;
            else if (ar[i][0] == 2) ind2 = i;
        }
        for (int i = 1; i < n; i++) {
            if (ar[(ind1 + i) % n][0] != i + 1) {
                ar[ind[i + 1]][0] = ar[(ind1 + i) % n][0];
                ar[(ind1 + i) % n][0] = i + 1;
                break;
            }
        }
        ind2 = (ind2 - 1 + n) % n;
        ar[ind[1]][1] = ar[ind2][1];
        ar[ind2][1] = 1;
        boolean bool = false;
        for (int i = 2; i < n; i++) {
            if ((ar[(ind1 + i) % n][0]) < (ar[(ind2 + i) % n][1])) {
                break;
            } else if ((ar[(ind1 + i) % n][0]) > (ar[(ind2 + i) % n][1])) {
                bool = true;
                break;
            }
        }
        if (bool) {
            for (int i = 0; i < n; i++) {
                System.out.print((ar[(ind2 + i) % n][1]) + " ");
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print((ar[(ind1 + i) % n][0]) + " ");
            }
        }
        System.out.println();
    }
}