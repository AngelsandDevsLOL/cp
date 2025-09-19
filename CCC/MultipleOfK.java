package CCC;

import java.util.Scanner;

public class MultipleOfK {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int y = scanner.nextInt();
        int[] array = new int[n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt() + x;
            x = array[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 0; j++) {
                break;
            }
        }
    }
}
