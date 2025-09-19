package Random;

import java.util.Scanner;

public class CheekyCheckers {
    public static int max = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dis = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                if (input.charAt(j) == 'B') {
                    dis[i][j] = 1;
                } else if (input.charAt(j) == 'A') {
                    dis[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (dis[i][j] == 2) {
                    recursion(i, j, 0, dis);
                }
            }
        }
        System.out.println(max);
    }
    public static void recursion (int x, int y, int count, int[][] dis) {
        int num = 0;
        if (check(x + 2, y + 2)) {
            if (dis[x + 2][y + 2] == 0 && dis[x + 1][y + 1] == 1) {
                dis[x + 1][y + 1] = 0;
                recursion(x + 2, y + 2, count + 1, dis);
                dis[x + 1][y + 1] = 1; num++;
            }
        }
        if (check(x + 2, y - 2)) {
            if (dis[x + 2][y - 2] == 0 && dis[x + 1][y - 1] == 1) {
                dis[x + 1][y - 1] = 0;
                recursion(x + 2, y - 2, count + 1, dis);
                dis[x + 1][y - 1] = 1; num++;
            }
        }
        if (check(x - 2, y - 2)) {
            if (dis[x - 2][y - 2] == 0 && dis[x - 1][y - 1] == 1) {
                dis[x - 1][y - 1] = 0;
                recursion(x - 2, y - 2, count + 1, dis);
                dis[x - 1][y - 1] = 1; num++;
            }
        }
        if (check(x - 2, y + 2)) {
            if (dis[x - 2][y + 2] == 0 && dis[x - 1][y + 1] == 1) {
                dis[x - 1][y + 1] = 0;
                recursion(x - 2, y + 2, count + 1, dis);
                dis[x - 1][y + 1] = 1; num++;
            }
        }
        if (num == 0) {
            max = Math.max(max, count);
        }
    }
    public static boolean check (int x, int y) {
        if (x >= 0 && y >= 0 && x < 8 && y < 8) {
            return true;
        }
        return false;
    }
}
