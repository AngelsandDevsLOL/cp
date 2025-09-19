package CCC.Senior;

import java.util.Scanner;

public class Flipper {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[][] array = {{1, 2}, {3, 4}};
        for (int i = 0; i < input.length(); i++) {
            int one = array[0][0];
            int two = array[0][1];
            int three = array[1][0];
            int four = array[1][1];
            if (input.substring(i,i+1).equals("H")) {
                array[0][0] = three;
                array[0][1] = four;
                array[1][0] = one;
                array[1][1] = two;
            } else {
                array[0][0] = two;
                array[0][1] = one;
                array[1][0] = four;
                array[1][1] = three;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
