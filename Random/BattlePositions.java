package Random;

import java.util.Scanner;

public class BattlePositions {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int n = scanner.nextInt();
        int j = scanner.nextInt();
        int[] ar = new int[i+2];
        for (int k = 0; k < j; k++) {
            int x = scanner.nextInt(); // troops go starting from here
            int y = scanner.nextInt(); // troops end from here
            int z = scanner.nextInt(); // num of troops
            ar[x] = ar[x] + z;
            ar[y+1] = ar[y+1] - z;
        }
        for (int k = 1; k < ar.length; k++) {
            ar[k] = ar[k-1] + ar[k];
        }
        int count = 0;
        for (int k = 1; k <= i; k++) {
            if (ar[k] >= n) {
                count++;
            }
        }
        System.out.println(i - count);
    }
}
