package CCC.Senior;

import java.util.Scanner;

public class ArithmeticSquare2 {
    public static int[][] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ar = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                if (input[j].equals("X")) {
                    ar[i][j] = Integer.MAX_VALUE;
                } else {
                    ar[i][j] = Integer.parseInt(input[j]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            update(i, i);
        }
        if (ar[1][1] == Integer.MAX_VALUE) {
            ar[1][1] = 0;
            update(1, 1);
        }
        if (ar[0][1] == Integer.MAX_VALUE) {
            ar[0][1] = 0;
            update(0, 1);
        }
        if (ar[1][0] == Integer.MAX_VALUE) {
            ar[1][0] = 0;
            update(1, 0);
        }
        if (ar[1][2] == Integer.MAX_VALUE) {
            ar[1][2] = 0;
            update(1, 2);
        }
        if (ar[2][0] == Integer.MAX_VALUE) {
            ar[2][0] = 0;
            update(2, 0);
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void update (int x, int y) {
        if (ar[x][0] != Integer.MAX_VALUE && ar[x][1] != Integer.MAX_VALUE) {
            if (ar[x][2] == Integer.MAX_VALUE) {
                ar[x][2] = 2 * ar[x][1] - ar[x][0];
                update(x, 2);
            }
        } else if (ar[x][0] != Integer.MAX_VALUE && ar[x][2] != Integer.MAX_VALUE) {
            if (ar[x][1] == Integer.MAX_VALUE) {
                ar[x][1] = (ar[x][2] - ar[x][0]) / 2 + ar[x][0];
                update(x, 1);
            }
        } else if (ar[x][2] != Integer.MAX_VALUE && ar[x][1] != Integer.MAX_VALUE) {
            if (ar[x][0] == Integer.MAX_VALUE) {
                ar[x][0] = ar[x][1] - (ar[x][2] - ar[x][1]);
                update(x, 0);
            }
        }

        if (ar[0][y] != Integer.MAX_VALUE && ar[1][y] != Integer.MAX_VALUE) {
            if (ar[2][y] == Integer.MAX_VALUE) {
                ar[2][y] = 2 * ar[1][y] - ar[0][y];
                update(2, y);
            }
        } else if (ar[0][y] != Integer.MAX_VALUE && ar[x][2] != Integer.MAX_VALUE) {
            if (ar[1][y] == Integer.MAX_VALUE) {
                ar[1][y] = (ar[2][y] - ar[0][y]) / 2 + ar[0][y];
                update(1, y);
            }
        } else if (ar[2][y] != Integer.MAX_VALUE && ar[1][y] != Integer.MAX_VALUE) {
            if (ar[0][y] == Integer.MAX_VALUE) {
                ar[0][y] = ar[1][y] - (ar[2][y] - ar[1][y]);
                update(0, y);
            }
        }
    }
}
