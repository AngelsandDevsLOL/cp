package AlphaStar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class HexagonalIslands {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(), h = sc.nextInt(), l = sc.nextInt() + 1;
        int[][] ar = new int[2 * k - 1][2 * k - 1];
        int count = 1;
        int x = 0;
        int y = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 2 * k - 2; j >= (k - 1 - i); j--) {
                if (count == h) {x = j; y = i;}
                ar[j][i] = count++;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 2 * k - 3 - i; j >= 0; j--) {
                if (count == h) {x = j; y = i + k;}
                ar[j][i + k] = count++;
            }
        }
        int[][] ans = new int[2 * k - 1][2 * k - 1];
        ans[x][y] = 1;
        int[][] directions = new int[][]{{-1, 1}, {0, 1}, {1, 0}, {-1, 0}, {1, -1}, {0, -1}};
        Queue<Integer> q = new LinkedList<>();
        q.add(x); q.add(y);
        while (!q.isEmpty()) {
            int x2 = q.poll(), y2 = q.poll();
            for (int i = 0; i < 6; i++) {
                    if (check(x2 + directions[i][0], y2 + directions[i][1], ar, ans)) {
                        q.add(x2 + directions[i][0]); q.add(y2 + directions[i][1]);
                        ans[x2 + directions[i][0]][y2 + directions[i][1]] = ans[x2][y2] + 1;
                    }
            }
        }
        TreeSet<Integer> answer = new TreeSet<>();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (ans[i][j] == l) {
                    answer.add(ar[i][j]);
                }
            }
        }
        System.out.println(answer.size());
        for (int num : answer) System.out.println(num);
    }
    public static boolean check (int x, int y, int[][] ar, int[][] ans) {
        if (x >= 0 && y >= 0 && x < ar.length && y < ar.length && ar[x][y] != 0 && ans[x][y] == 0) return true;
        return false;
    }
}
