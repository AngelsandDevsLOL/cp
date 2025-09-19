package CCC.Junior;

import java.util.Scanner;

public class MagicSquares {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] row = new int[4];
        int[] col = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int input = scanner.nextInt();
                row[j] = row[j] + input;
                col[i] = col[i] + input;
            }
        }
        int sum = row[0];
        boolean bool = true;
        for (int i = 1; i < 4; i++) {
            if (row[i] != sum) {
                bool = false;
                break;
            }
        }
        if (bool) {
            for (int i = 0; i < 4; i++) {
                if (col[i] != sum) {
                    bool = false;
                    break;
                }
            }
        }
        if (bool) {
            System.out.println("magic");
        } else {
            System.out.println("not magic");
        }
    }
}
