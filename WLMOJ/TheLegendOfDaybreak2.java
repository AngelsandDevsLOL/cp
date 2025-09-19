package WLMOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheLegendOfDaybreak2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] dis = new int[n][m];
        ArrayList<Integer> t = new ArrayList<>();
        int testx = 0, testy = 0;
        dis[n - 1][0] = 1;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'W') {
                    dis[i][j] = -1;
                } else if (input.charAt(j) == 'T') {
                    dis[i][j] = -1;
                    t.add(i);
                    t.add(j);
                } else if (input.charAt(j) == 't') {
                    testx = i;
                    testy = j;
                }
            }
        }
        while (!t.isEmpty()) {
            int x = t.remove(0);
            int y = t.remove(0);
            for (int i = x + 1; i < n; i++) {
                if (dis[i][y] == -1) {
                    break;
                }
                dis[i][y] = -1;
            }
            for (int i = y + 1; i < m; i++) {
                if (dis[x][i] == -1) {
                    break;
                }
                dis[x][i] = -1;
            }
            for (int i = x - 1; i >= 0; i--) {
                if (dis[i][y] == -1) {
                    break;
                }
                dis[i][y] = -1;
            }
            for (int i = y - 1; i >= 0; i--) {
                if (dis[x][i] == -1) {
                    break;
                }
                dis[x][i] = -1;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(n - 1);
        q.add(0);
        int[][] directions = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        if (dis[n - 1][0] == -1) {
            System.out.println(-1);
            return;
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                if (check(x + directions[i][0], y + directions[i][1], n, m)) {
                    if (dis[x + directions[i][0]][y + directions[i][1]] == 0) {
                        dis[x + directions[i][0]][y + directions[i][1]] = dis[x][y] + 1;
                        q.add(x + directions[i][0]);
                        q.add(y + directions[i][1]);
                    }
                }
            }
        }
        System.out.println((dis[testx][testy] == 0 || dis[testx][testy] == -1) ? -1 : (dis[testx][testy] - 1) * 2 + 1);
    }
    public static boolean check(int x, int y, int n, int m){
        if (x >= 0 && y >= 0 && x < n && y < m) return true;
        return false;
    }
}
