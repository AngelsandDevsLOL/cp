package AlphaStar;

import java.util.*;
import java.io.*;

public class TheGrove {
    public static void main (String[] args) throws IOException {
        int r = readInt(), c = readInt();
        short topX = -1, topY = 0;
        char[][] input = new char[r][c];
        short starX = 0, starY = 0;
        for (short i = 0; i < r; i++) {
            String s = readLine();
            for (short j = 0; j < c; j++) {
                input[i][j] = s.charAt(j);
                if (input[i][j] == '*') {
                    starX = i; starY = j;
                }
                if (topX == -1 && input[i][j] == 'X') {
                    topX = i; topY = j;
                }
            }
        }
        Queue<Short> q = new LinkedList<Short>();
        short[][][] ar = new short[r][c][2];
        q.add(starX); q.add(starY); q.add((short)0); q.add((short)0);
        for (short[][] temp : ar) {
            for (short[] temp2 : temp) {
                Arrays.fill(temp2, (short)32766);
            }
        }
        ar[starX][starY][0] = 0;
        int[][] direction = new int[][]{{-1, 1, 0, 0, -1, -1, 1, 1}, {0, 0, -1, 1, 1, -1, 1, -1}};
        while (!q.isEmpty()) {
            short px = q.poll(), py = q.poll(), pz = q.poll(), pbool = q.poll();
            short tempz = (short) (pz + 1);
            for (int i = 0; i < 8; i++) {
                short nextX = (short) (px + direction[0][i]);
                short nextY = (short) (py + direction[1][i]);
                if (check(nextX, nextY, r, c) && !(input[nextX][nextY] == 'X')) {
                    boolean cross = (nextX <= topX && px <= topY) && ((nextY >= topY && py < topY) || (nextY < topY && py >= topY));
                    if (cross) {
                        if (pbool == 0) {
                            if (ar[nextX][nextY][1] < tempz) continue;
                            ar[nextX][nextY][1] = (tempz);
                            q.add(nextX); q.add(nextY); q.add((tempz)); q.add((short) 1);
                        }
                    } else {
                        if (ar[nextX][nextY][pbool] < tempz) continue;
                        ar[nextX][nextY][pbool] = (tempz);
                        q.add(nextX); q.add(nextY); q.add(tempz); q.add(pbool);
                    }
                }
            }
        }
        System.out.println(ar[starX][starY][1]);
    }
    public static boolean check (int x, int y, int r, int c) {
        if (x >= 0 && y >= 0 && x < r && y < c) return true;
        return false;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}