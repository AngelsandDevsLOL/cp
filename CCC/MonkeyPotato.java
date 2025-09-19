package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class MonkeyPotato {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        int[] array = new int[d];
        for (int i = 0; i < d; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        if (array[0] != 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(array[0]);
            }
        } else if (array[0] == 0 && k == 1 && d > 1) {
            System.out.print(array[1]);
        } else if (array[0] == 0 && k != 1 && k != 0 && d > 1) {
            System.out.print(array[1]);
            for (int i = 0; i < k - 2; i++) {
                System.out.print(array[0]);
            }
            System.out.print(array[1]);
        } else {
            System.out.print(-1);
        }
        System.out.println();
    }
}