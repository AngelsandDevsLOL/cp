package CCC;

import java.util.Scanner;

public class HackerSoup {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] array = new int[n][n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = num;
                num++;
            }
        }
        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            rotating(array, x1 - 1, y1 - 1, x2 - 1, y2 - 1);
        }
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(array[x-1][y-1]);
        }
    }

    static void rotating(int[][] array, int x1, int y1, int x2, int y2) {
        int integer = (y2 - y1 + 1) / 2;
        for (int j = 0; j < integer; j++) {
            int[] ar = new int[x2 - x1 + 1];
            int[] arr = new int[x2 - x1 + 1];
            int[] arra = new int[x2 - x1 + 1];
            int[] arraa = new int[x2 - x1 + 1];
            int num = x2-x1;
            for (int k = x1; k - 1 < x2; k++) {
                ar[num] = array[k][x1];
                num--;
            }
            num = 0;
            for (int k = x1; k - 1 < x2; k++) {
                arr[num] = array[x1][k];
                num++;
            }
            num = 0;
            for (int k = x1; k - 1 < x2; k++) {
                arra[num] = array[x2][k];
                num++;
            }
            num = x2-x1;
            for (int k = x1; k - 1 < x2; k++) {
                arraa[num] = array[k][x2];
                num--;
            }
            num = 0;
            for (int i = x1; i < x2 + 1; i++) {
                array[x1][i] = ar[num];
                array[i][x2] = arr[num];
                array[i][x1] = arra[num];
                array[x2][i] = arraa[num];
                num++;
            }
        }
    }
}