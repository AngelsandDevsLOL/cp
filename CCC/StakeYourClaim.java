package CCC;

import java.util.Scanner;

public class StakeYourClaim {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        String[][] array = new String[c][r];
        scanner.nextLine();
        for (int i = 0; i < c*2+1; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < r*2+1; j++) {
                array[i][j] = input.substring(j,j+1);
            }
        }
        for (int i = 0; i < c*2+1; i++) {

        }
    }
}