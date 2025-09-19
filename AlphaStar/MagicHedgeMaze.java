package AlphaStar;

import java.util.*;
import java.io.*;

public class MagicHedgeMaze {
    public static void main (String[] args) throws IOException {
        short n = (short) readInt(),m = (short) readInt();
        short[][] ar = new short[n][m];
        short[][] dis = new short[n][m];
        int destinationX = 0, destinationY = 0;
        int startX = 0, startY = 0;
        int[][] portal = new int[27][4];
        for (int i = 0; i < n; i++) {
            String input = readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '#') ar[i][j] = -1;
                else if (input.charAt(j) == '=') {destinationX = i; destinationY = j;}
                else if (input.charAt(j) == '@') {startX = i; startY = j;}
                else if (input.charAt(j) == '.') {}
                else {
                    short temp = (short) (input.charAt(j) - 'A' + 1);
                    ar[i][j] = temp;
                    if (portal[temp][0] == 0 && portal[temp][1] == 0) {
                        portal[temp][0] = i;
                        portal[temp][1] = j;
                    } else {
                        portal[temp][2] = i;
                        portal[temp][3] = j;
                    }
                }
            }
            Arrays.fill(dis[i], Short.MAX_VALUE);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(startX); q.add(startY);
        dis[startX][startY] = 0;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int x = q.poll(), y = q.poll();
            if (destinationX == x && destinationY == y) break;
            for (int i = 0; i < 4; i++) {
                int num = ar[x + direction[i][0]][y + direction[i][1]];
                if (num == -1) continue;
                else if (num == 0 && dis[x + direction[i][0]][y + direction[i][1]] > dis[x][y]) {
                    dis[x + direction[i][0]][y + direction[i][1]] = (short) (dis[x][y] + 1);
                    q.add(x + direction[i][0]); q.add(y + direction[i][1]);
                } else if (num != 0) {
                    if (portal[num][0] == x + direction[i][0] && portal[num][1] == y + direction[i][1]) {
                        int nextX = portal[num][2]; int nextY = portal[num][3];
                        if (dis[nextX][nextY] > dis[x][y] + 1) {
                            dis[nextX][nextY] = (short) (dis[x][y] + 1);
                            q.add(nextX);
                            q.add(nextY);
                        }
                    } else {
                        int nextX = portal[num][0]; int nextY = portal[num][1];
                        if (dis[nextX][nextY] > dis[x][y] + 1) {
                            dis[nextX][nextY] = (short) (dis[x][y] + 1);
                            q.add(nextX);
                            q.add(nextY);
                        }
                    }
                }
            }
        }
        System.out.println(dis[destinationX][destinationY]);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
