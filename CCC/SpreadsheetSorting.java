package CCC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SpreadsheetSorting {
    static int r, c, n, array[][], col;
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        array = new int[r][c];
        Integer row[] = new Integer[r];
        for (int i = 0; i < r; i++) {
            row[i] = i;
            for (int j = 0; j < c; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            col = scanner.nextInt() - 1;
            Arrays.sort(row, new cmp());
        }
        for (int i = 0; i < r; i++) {
            int R = row[i];
            for (int j = 0; j < c; j++) {
                System.out.print(array[R][j] + " ");
            }
            System.out.println();
        }
    }
    static class cmp implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return Integer.compare(array[x][col], array[y][col]);
        }
    }
}
