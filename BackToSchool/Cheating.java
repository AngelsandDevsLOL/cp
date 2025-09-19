package BackToSchool;

import java.util.Scanner;

public class Cheating {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long[] psa = new long[m + 1];
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            int people = sc.nextInt();
            psa[pointer] += points[i];
            if (pointer + people > m) {
                psa[0] += points[i];
                psa[(pointer + people) - m] -= points[i];
                pointer += people - m;
            } else {
                psa[pointer + people] -= points[i];
                pointer += people;
            }
        }
        System.out.print(psa[0] + " ");
        for (int i = 1; i < m; i++) {
            psa[i] += psa[i - 1];
            System.out.print(psa[i]);
            if (i != m - 1) System.out.print(" ");
        }
    }
}
