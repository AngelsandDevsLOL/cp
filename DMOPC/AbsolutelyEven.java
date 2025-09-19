package DMOPC;

import java.util.Scanner;

public class AbsolutelyEven {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar;
        if (n % 2 == 0) { // even [1, -2, -3, 4]
            ar = new int[]{1, -1, -1, 1};
        } else { // odd, [1, 2, -3, -4]
            ar = new int[]{1, 1, -1, -1};
        }
        int maxNeg = 0; // max neg
        int conNeg = 0; // consecutive neg
        int maxPos = 0; // max pos
        int conPos = 0; // consecutive pos
        for (int i = 0; i < n; i++) {
            int x = i % 4;
            int y = (i + 3) % 4;
            if (ar[x] == ar[y]) {
                if (ar[x] == -1) {
                    System.out.print("-1 ");
                } else {
                    System.out.print("0 ");
                }
            } else {
                if (ar[x] == -1) {
                    conNeg = -1 * Math.max(maxPos, conPos) - 1;
                    System.out.print(conNeg-- + " ");
                    maxPos = Math.min(maxPos, conPos);
                    conPos = 0;
                } else {
                    conPos = -1 * Math.min(maxNeg, conNeg);
                    System.out.print(conPos + " ");
                    maxNeg = Math.max(maxNeg, conNeg);
                    conNeg = 0;
                }
            }
        }
        System.out.println();
    }
}
