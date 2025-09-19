package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class HighTideLowTide {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        int[] ar = new int[(int)n];
        for (int i = 0; i < (int)n; i++) {
            ar[i] = scanner.nextInt();
        }
        Arrays.sort(ar);
        int x = (int)Math.ceil(n/2);
        int[] low = new int[x];
        int[] high = new int[(int) (n-x)];
        for (int i = 0; i < low.length; i++) {
            low[i] = ar[i];
        }
        for (int i = 0; i < high.length; i++) {
            high[i] = ar[i + x];
        }
        int num = low.length-1;
        for (int i = 0; i < low.length; i++) {
            System.out.print(low[num] + " ");
            if (high.length > i) {
                System.out.print(high[i] + " ");
            }
            num--;
        }
    }
}