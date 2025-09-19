package CCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BridgeCrossing {
    static int m;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int q = sc.nextInt();
        int[][] ar = new int[q][q];
        String[] names = new String[q];
        for (int i = 0; i < q; i++) {
            Arrays.fill(ar[i], Integer.MAX_VALUE);
            sc.nextLine();
            String name = sc.nextLine();
            int time = sc.nextInt();
            ar[i][i] = time;
            names[i] = name;
        }
        for (int i = q - 2; i >= 0; i--) { // start from second-last (last is literally a sitting duck)
            for (int j = i + 1; j < m + i && j < q; j++) {
                ar[i][j] = Math.max(ar[i][j - 1], ar[j][j]);
            }
            for (int j = i + 1; j <= q - 1; j++) {
                for (int k = i; k < j; k++) {
                    ar[i][j] = Math.min((ar[i][k] + ar[k + 1][j]), ar[i][j]);
                }
            }
        }
        System.out.println("Total Time: " + ar[0][q - 1]);
        System.out.println(recursion(0, q - 1, ar, names));
    }
    public static String recursion (int row, int col, int[][] ar, String[] names) {
        if (col == row) return names[col];
        if (col - row < m) {
            StringBuilder sb = new StringBuilder();
            for (int i = row; i <= col; i++) {
                sb.append(names[i] + " ");
            }
            return sb.toString();
        }
        for (int i = row; i < col; i++) {
            if (ar[row][col] == ar[row][i] + ar[i + 1][col]) {
                return recursion(row, i, ar, names) + "\n" + recursion(i + 1,col, ar, names);
            }
        }
        return null; // will never happen
    }
}
