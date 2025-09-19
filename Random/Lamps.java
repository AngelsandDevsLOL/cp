package Random;

import java.util.Arrays;
import java.util.Scanner;

public class Lamps {
    public static int[][] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ar = new int[Integer.bitCount(m) + 1][n];
        int[] arr = new int[Integer.bitCount(m) + 1];
        for (int i = 1; i < ar.length; i++) {
            Arrays.fill(ar[i], -1);
        }
        String s = Integer.toBinaryString(m);
        int cnt = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                arr[arr.length - cnt++] = (int)(Math.pow(2, s.length() - i - 1));
            }
        }
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            ar[0][i] = in;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(recursion(i, arr.length - 1, arr, m));
        }
    }
    // ind is the index of the light bulb
    // curGen is generation number
    // gen is the generations left
    // arr is the list of #s that will be future generations (After minusing)
    public static int recursion (int ind, int gen, int[] arr, int curGen) {
        if (ar[gen][ind] != -1) return ar[gen][ind];
        ar[gen][ind] = recursion(ind, gen - 1, arr, curGen - arr[gen]) ^ recursion((ind + arr[gen]) % ar[0].length, gen - 1, arr, curGen - arr[gen]);
        return ar[gen][ind];
    }
}
