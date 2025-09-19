package CCC.Senior;

import java.util.Arrays;
import java.util.Scanner;

public class VoronoiVillages {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        Arrays.sort(ar);
        int x = 1;
        double smallest = Double.MAX_VALUE;
        for (int i = 1; i <= n-2; i++) {
            double sum = ar[i+1] - ar[i-1];
            sum = sum / 2;
            if (smallest > sum) {
                smallest = sum;
            }
        }
        System.out.printf("%.1f%n",smallest);
    }
}
