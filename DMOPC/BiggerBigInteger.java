package DMOPC;

import java.util.Scanner;

public class BiggerBigInteger {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        boolean bool = true;
        int[] array = new int[d];
        int x = Integer.parseInt(input.substring(0,1));
        String string = String.valueOf(x);
        boolean bool2 = true;
        for (int i = 0; i < d; i++) {
            int y = Integer.parseInt(input.substring(i,i+1));
            if (y > x) {
                bool2 = false;
            }
        }
        if (bool2) {
            for (int i = 1; i < d; i++) {
                int y = Integer.parseInt(input.substring(i, i + 1));
                if (bool && y > x) {
                    string = string.substring(0, i - 1);
                    string = string + y + x;
                    bool = false;
                } else {
                    string = string + y;
                }
                if (!bool) {
                    string = string + input.substring(i + 1);
                    break;
                }
                x = y;
            }
        } else {
            string = input;
        }
        System.out.println(string);
    }
}
