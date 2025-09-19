package CCC.Senior;

import java.util.Scanner;

public class ArithmeticSquare {
    public static int[][] array;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String[] ar = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                if (ar[j].equals("X")) {
                    array[i][j] = Integer.MIN_VALUE;
                } else {
                    array[i][j] = Integer.parseInt(ar[j]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            update(i, i);
        }
        if (array[1][1] == Integer.MIN_VALUE) {
            array[1][1] = 0;
            update(1, 1);
        }
        if (array[0][1] == Integer.MIN_VALUE) {
            array[0][1] = 0;
            update(0, 1);
        }
        if (array[1][0] == Integer.MIN_VALUE) {
            array[1][0] = 0;
            update(1, 0);
        }
        if (array[1][2] == Integer.MIN_VALUE) {
            array[1][2] = 0;
            update(1, 2);
        }
        if (array[2][0] == Integer.MIN_VALUE) {
            array[2][0] = 0;
        }
            for (int i = 0; i < 3; i++) { // fake the row
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (array[i][j] != Integer.MIN_VALUE) count++;
            }
            if (count == 1) {
                if (array[i][0] != Integer.MIN_VALUE) {
                    array[i][1] = array[i][0];
                    update(i, 1);
                } else if (array[i][1] != Integer.MIN_VALUE) {
                    array[i][0] = array[i][1];
                    update(i, 0);
                } else {
                    array[i][0] = array[i][2];
                    update(i, 0);
                }
            }
        }
        for (int i = 0; i < 3; i++) { // fake the col
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (array[j][i] != Integer.MIN_VALUE) count++;
            }
            if (count == 1) {
                if (array[0][i] != Integer.MIN_VALUE) {
                    array[1][i] = array[0][i];
                    update(i, 1);
                } else if (array[1][i] != Integer.MIN_VALUE) {
                    array[0][i] = array[1][i];
                    update(i, 0);
                } else {
                    array[0][i] = array[2][i];
                    update(i, 0);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void update(int r, int c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (array[r][i] != Integer.MIN_VALUE) count++;
        }
        if (count == 2) {
            if (array[r][0] == Integer.MIN_VALUE) {
                array[r][0] = -array[r][2] + 2*array[r][1];
                update(r, 0);
            } else if (array[r][1] == Integer.MIN_VALUE) {
                array[r][1] = (array[r][2] - array[r][0]) / 2 + array[r][0];
                update(r, 1);
            } else {
                array[r][2] = array[r][1] - array[r][0] + array[r][1];
                update(r, 2);
            }
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (array[i][c] != Integer.MIN_VALUE) count++;
        }
        if (count == 2) {
            if (array[0][c] == Integer.MIN_VALUE) {
                array[0][c] = -array[2][c] + 2*array[1][c];
                update(0, c);
            } else if (array[1][c] == Integer.MIN_VALUE) {
                array[1][c] = (array[2][c] - array[0][c]) / 2 + array[0][c];
                update(1, c);
            } else {
                array[2][c] = array[1][c] - array[0][c] + array[1][c];
                update(2, c);
            }
        }
    }
}
