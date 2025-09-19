package COCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Pohlepko {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                ar[i][j] = input.charAt(j) - 'a';
            }
        }
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(0);
        System.out.print((char)(ar[0][0] + 'a'));
        for (int x = 1; x < n + m - 1; x++) { // i + j = x
            int best = 26;
            HashSet<Integer> ind = new HashSet<>();
            for (int i : hSet) {
                int j = x - i - 1;
                if (j + 1 < m) {
                    int num = ar[i][j + 1];
                    if (best > num) {
                        best = num;
                        ind = new HashSet<>();
                        ind.add(i);
                    } else if (best >= num) {
                        best = num;
                        ind.add(i);
                    }
                }
                if (i + 1 < n) {
                    int num = ar[i + 1][j];
                    if (best > num) {
                        best = num;
                        ind = new HashSet<>();
                        ind.add(i + 1);
                    } else if (best >= num) {
                        best = num;
                        ind.add(i + 1);
                    }
                }
            }
            hSet = ind;
            System.out.print((char)(best + 'a'));
        }
        System.out.println();
    }
}
