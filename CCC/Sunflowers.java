package CCC;

import java.util.Scanner;

public class Sunflowers {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int corner1 = array[0][0], corner2 = array[0][n - 1], corner3 = array[n - 1][0];
        int num = 0;
        if (corner1 < corner2 && corner1 < corner3) {
            // no change
        } else if (corner1 < corner2 && corner1 > corner3) {
            // was rotated 270 degrees clockwise (rotate it 90 degrees clockwise)
            num = 1;
        } else if (corner1 > corner2 && corner1 < corner3) {
            // was rotated 90 degrees clockwise (rotate it 270 degrees clockwise)
            num = 3;
        } else {
            // was rotated 180 degrees (rotate it 180 degrees)
            num = 2;
        }
        int[][] newAr = rotate(array, new int[n][n], num);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(newAr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] rotate (int[][] ar, int[][] newAr, int num) {
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
        return rotate(newAr, new int[n][n], --num);
    }
}
