package CCC.Senior;

import java.util.Scanner;

public class SwappingSeats2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[][] ar = new int[input.length() + 1][3];
        for (int i = 1; i <= input.length(); i++) {
            ar[input.charAt(i) - 'A'][i]++;
        }
        int a = ar[0][input.length() - 1];
        int b = ar[1][input.length() - 1];
        int c = ar[2][input.length() - 1];
        for (int i = 0; i < input.length(); i++) { // ind to start a
            // i, i + a,
        }
    }
}
