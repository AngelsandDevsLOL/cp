package CCC.MockJ;

import java.util.Arrays;
import java.util.Scanner;

public class AMedianProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = scanner.nextInt();
            }
            Arrays.sort(input);
            array[i] = (input[(n/2)]);
        }
        Arrays.sort(array);
        System.out.println(array[n/2]);
    }
}
