package Random;

import java.util.Scanner;

public class TripNavigator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int time = 0;
        int t = scanner.nextInt();
        String[][] array = new String[n][n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = input.substring(j,j+1);
            }
        }
        int hi = 0;

    }
}