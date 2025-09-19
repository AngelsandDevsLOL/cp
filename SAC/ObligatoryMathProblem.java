package SAC;

import java.util.Arrays;
import java.util.Scanner;

public class ObligatoryMathProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        if (n % 2 == 0) {
            System.out.println((array[n / 2] + array[n / 2 - 1]) / 2);
        } else {
            System.out.println(array[n / 2]);
        }
    }
}
