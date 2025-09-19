package CCC.Senior;

import java.util.Scanner;

public class Sunflowers {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] array = new String[n][n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] ar = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = ar[j];
            }
        }
        array = rotate(array, new String[n][n], 2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static String[][] rotate (String[][] ar, String[][] newAr, int num) {
        if (num == 0) return ar;
        int n = ar.length;
        int x = (int)Math.ceil(n/ 2.0);
        for (int i = 0; i < x; i++) {
            for (int j = i; j < n - i; j++) {
                newAr[j][n - i - 1] = ar[i][j];
                newAr[n - i - 1][n - j - 1] = ar[j][n - i - 1];
                newAr[n - j - 1][i] = ar[n - i - 1][n - j - 1];
                newAr[i][j] = ar[n - j - 1][i];
            }
        }
        return rotate(newAr, new String[n][n], --num);
    }
}