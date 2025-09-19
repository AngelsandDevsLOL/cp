package DMOPC;

import java.util.Scanner;

public class BrotherlySequence {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int largest = 1;
        int num = 1;
        int input = scanner.nextInt();
        for (int i = 1; i < n; i++) {
            int x = scanner.nextInt();
            if (x - input <= 2 ) {
                num++;
            } else {
                largest = Math.max(num, largest);
                num = 1;
            }
            input = x;
        }
        System.out.println(largest);
    }
}
