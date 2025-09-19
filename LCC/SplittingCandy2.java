package LCC;

import java.util.Arrays;
import java.util.Scanner;

public class SplittingCandy2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int[] psa = new int[m + 1];
        int[] lastIndex = new int[(int) 1e6];
        psa[0] = (int) 1e5;
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < m; i++) {
            if (input.charAt(i) == '0') {
                psa[i + 1] += psa[i] - 1;
            } else {
                psa[i + 1] += psa[i] + 1;
            }
            lastIndex[psa[i + 1]] = i;
        }
        for (int i = 0; i < q; i++) {
            int index = sc.nextInt();
            System.out.println(lastIndex[psa[index]] - index + 1);
        }
    }
}