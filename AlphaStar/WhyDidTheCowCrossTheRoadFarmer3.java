package AlphaStar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WhyDidTheCowCrossTheRoadFarmer3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), r = sc.nextInt();
        int[][] ar = new int[n * 2][n * 2];
        for (int i = 0; i < r; i++) {
            int x1 = sc.nextInt() - 1, y1 = sc.nextInt() - 1, x2 = sc.nextInt() - 1, y2 = sc.nextInt() - 1;
            if (x2 - x1 != 0) {//up or down
                if (x2 - x1 == 1) { //up -> down
                    ar[x1 * 2 + 1][y1 * 2] = -1;
                    ar[x1 * 2 + 1][y1 * 2 + 1] = -1;
                    if (y1 != 0) ar[x1 * 2 + 1][y1 * 2 - 1] = -1;
                } else {
                    ar[x2 * 2 + 1][y1 * 2] = -1;
                    ar[x2 * 2 + 1][y1 * 2 + 1] = -1;
                    if (y1 != 0) ar[x2 * 2 + 1][y1 * 2 - 1] = -1;
                }
            } else {
                if (y2 - y1 == 1) {// left -> right
                    ar[x1 * 2][y1 * 2 + 1] = -1;
                    ar[x1 * 2 + 1][y1 * 2 + 1] = -1;
                    if (x1 != 0) ar[x1 * 2 + 1][y1 * 2 + 1] = -1;
                } else { // right -> left
                    ar[x1 * 2][y1 * 2 - 1] = -1;
                    ar[x1 * 2 + 1][y1 * 2 - 1] = -1;
                    if (x1 != 0) ar[x1 * 2 + 1][y1 * 2 - 1] = -1;
                }
            }
        }
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i * 2][j * 2] == 0) {
                    ar[i * 2][j * 2] = count++;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i * 2); q.add(j * 2);
                    while (!q.isEmpty()) {
                        int x = q.poll(), y = q.poll();
                        int[][] path = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                        for (int l = 0; l < 4; l++) {
                            if (check(x + path[l][0], y + path[l][1], 2 * n - 1) && ar[x + path[l][0]][y + path[l][1]] == 0) {
                                ar[x + path[l][0]][y + path[l][1]] = ar[x][y];
                                q.add(x + path[l][0]);
                                q.add(y + path[l][1]);
                            }
                        }
                    }
                }
            }
        }
        long[] sets = new long[count];
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            sets[ar[x * 2][y * 2]]++;
        }
        long ans = 0;
        for (int i = 1; i < count; i++) {
            ans += (long) sets[i] * (k - sets[i]);
        }
        System.out.println(ans / 2);
    }
    public static boolean check (int x, int y, int a) {
        if (x < a && y < a && x >= 0 && y >= 0) return true;
        return false;
    }
}
