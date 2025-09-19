package OTH;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoffeeJelly {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] ar = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        sc.nextLine();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'X') {
                    ar[i][j] = -1;
                } else if (input.charAt(j) == '*') {
                    ar[i][j] = -1;
                    q.add(i);
                    q.add(j);
                }
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll(), y = q.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (((i == 0 && j != 0) || (j == 0 && i != 0)) && check(x + i, y + j, n, m) && ar[x + i][y + j] == 0) {
                        ar[x + i][y + j] = -1;
                        q.add(x + i);
                        q.add(y + j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ar[i][j] == 0) {
                    ar[i][j] = ++count;
                    q.add(i); q.add(j);
                    while (!q.isEmpty()) {
                        int x = q.poll(), y = q.poll();
                        for (int ii = -1; ii <= 1; ii++) {
                            for (int jj = -1; jj <= 1; jj++) {
                                if (((ii == 0 && jj != 0) || (jj == 0 && ii != 0)) && check(x + ii, y + jj, n, m) && ar[x + ii][y + jj] == 0) {
                                    ar[x + ii][y + jj] = count;
                                    q.add(x + ii);
                                    q.add(y + jj);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static boolean check (int x, int y, int n, int m) {
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }
}
