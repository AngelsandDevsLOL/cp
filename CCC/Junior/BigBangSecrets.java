package CCC.Junior;

import java.util.Scanner;

public class BigBangSecrets {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            int s = 3 * (i + 1) + k;
            char c = input.charAt(i);
            c = (char) (c - s);
            if (c < 65) {
                c = (char) (c + 26);
            }
            System.out.print(c);
        }
    }
}
