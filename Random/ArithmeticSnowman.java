package Random;

import java.util.Arrays;
import java.util.Scanner;

public class ArithmeticSnowman {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            int x = array[i];
            for (int j = i + 1; j < n; j++) {

            }
        }
    }
}
