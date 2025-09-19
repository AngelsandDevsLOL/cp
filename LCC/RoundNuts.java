package LCC;

import java.util.Arrays;
import java.util.Scanner;

public class RoundNuts {
    public static void main (String args[]) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        double[] ar = new double[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ar[i] = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
        }
        Arrays.sort(ar);

    }
}
