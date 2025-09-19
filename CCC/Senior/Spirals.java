package CCC.Senior;

import java.util.Scanner;

public class Spirals {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int number = x - y + 1;
        int largest = 1;
        for (int i = 1; i <= 10; i++) {
            if (number <= i*i) {
                largest = i;
            }
        }
        int xx = largest;
        int yy = largest;
        int rem = number - (largest * largest);
        if (rem <= largest && rem > 0) {
            xx++;
        } else if (rem > largest && rem <= largest + largest + 1) {
            xx++;
            yy++;
        } else if (rem > largest + largest + 1 && rem <= (3 * largest) + 2) {
            xx++;
            xx++;
            y++;
        } else if (rem == 0) {

        } else {
            xx++;
            xx++;
            yy++;
            yy++;
        }
        int[][] array = new int[yy][xx];
// check spirals2
    }
}
