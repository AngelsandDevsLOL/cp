package DMOPC;

import java.util.Scanner;

public class UpDownSequence {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int x = scanner.nextInt();
            int[] ar = new int[x];
            for (int j = 0; j < x; j++) {
                ar[j] = scanner.nextInt();
            }
            boolean finalb = true;
            boolean bool = false; // decrease
            boolean skip = false; // 0
            if (ar[0] == 0) {
                skip = true;
            }
            if (ar[1] - ar[0] > 0 && !skip) {
                bool = true;
            } else if (ar[1] == ar[0] && !skip) {
                finalb = false;
            }
            for (int j = 1; j < ar.length-1 && finalb; j++) {
                if (ar[j] == 0 || ar[j+1] == 0) {
                    continue;
                }
                boolean b2 = ar[j + 1] - ar[j] > 0;
                if (bool == b2) {
                    finalb = false;
                }
                    bool = b2;
                if (ar[j + 1] == ar[j]) {
                    finalb = false;
                }
            }
            if (finalb) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}