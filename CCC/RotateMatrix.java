package CCC;

import java.util.Scanner;

public class RotateMatrix {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[][] array = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = w-1; i >= 0; i--) {
            for (int j = 0; j < h; j++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }
}
