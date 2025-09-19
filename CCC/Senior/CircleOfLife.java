package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class CircleOfLife {
    public static int[][] ar;
    public static int n;
    public static int[] bit;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); long t = sc.nextLong();
        sc.nextLine();
        String in = sc.nextLine();
        ar = new int[Long.bitCount(t) + 1][n];
        bit = new int[Long.bitCount(t) + 1];
        String binary = Long.toBinaryString(t);
        int point = bit.length - 1;
        for (int i = 1; i < ar.length; i++) {
            Arrays.fill(ar[i], -1);
        }
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') bit[point--] = binary.length() - i - 1;
        }
        for (int i = 0; i < n; i++) {
            if (in.charAt(i) == '1') {ar[0][i] = 1;}
        }
        for (int i = 0; i < n; i++) {
            System.out.print(recursion(i, bit.length - 1) ? 1 : 0);
        }
        System.out.println();
    }
    public static boolean recursion (int ind, int gen) {
        if (gen == 0) return ar[0][ind] == 0;
        int p1 = (int)((ind - Math.pow(2, bit[gen])) % n + n) % n;
        if (ar[gen - 1][p1] == -1) recursion(p1, gen - 1);

        int p2 = (int)((ind + Math.pow(2, bit[gen])) % n + n) % n;
        if (ar[gen - 1][p2] == -1) recursion(p2, gen - 1);
        ar[gen][ind] = ar[gen - 1][p1] != ar[gen - 1][p2] ? 1 : 0;
        return ar[gen][ind] == 1;
    }
}
