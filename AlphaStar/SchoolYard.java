package AlphaStar;

import java.util.*;
import java.io.*;

public class SchoolYard {
    public static void main (String[] args) throws IOException {
        int n = readInt(), s = readInt();
        int[][] ar = new int[n][4];
        int[][] students = new int[s][2];
        TreeSet<Integer> x = new TreeSet<>();
        TreeSet<Integer> y = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
            x.add(x1); x.add(x2);
            y.add(y1); y.add(y2);
            ar[i][0] = x1; ar[i][1] = y1; ar[i][2] = x2; ar[i][3] = y2;
        }
        for (int i = 0; i < s; i++) {
            int x1 = readInt(), y1 = readInt();
            x.add(x1); y.add(y1);
            students[i][0] = x1;students[i][1] = y1;
        }
        TreeMap<Integer, Integer> tMap1 = new TreeMap<>();
        TreeMap<Integer, Integer> tMap2 = new TreeMap<>();
        int count = 0;
        for (int num : x) {
            tMap1.put(num, count++);
        }
        count = 0;
        for (int num : y) {
            tMap2.put(num, count++);
        }
        int[][] array = new int[x.size() * 2][y.size() * 2];
        for (int i = 0; i < n; i++) {
            if (ar[i][0] == ar[i][2]) { // vertical line
                int xx = tMap1.get(ar[i][0]) * 2;
                int min = Math.min(tMap2.get(ar[i][1]), tMap2.get(ar[i][3]));
                int max = Math.max(tMap2.get(ar[i][3]), tMap2.get(ar[i][1]));
                for (int j = min * 2; j <= max * 2; j++) {
                    array[xx][j] = -1;
                }
            } else {
                int yy = tMap2.get(ar[i][1]) * 2;
                int min = Math.min(tMap1.get(ar[i][0]), tMap1.get(ar[i][2]));
                int max = Math.max(tMap1.get(ar[i][0]), tMap1.get(ar[i][2]));
                for (int j = min * 2; j <= max * 2; j++) {
                    array[j][yy] = -1;
                }
            }
        }
        count = 1;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < x.size() * 2; i += 2) {
            for (int j = 0; j < y.size() * 2; j += 2) {
                if (array[i][j] == 0) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i); q.add(j);
                    array[i][j] = count++;
                    while (!q.isEmpty()) {
                        int curX = q.poll(), curY = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = directions[k][0] + curX;
                            int nextY = directions[k][1] + curY;
                            if (check(nextX, nextY, x.size(), y.size()) && array[nextX][nextY] == 0){
                                q.add(nextX); q.add(nextY);
                                array[nextX][nextY] = array[curX][curY];
                            }
                        }
                    }
                }
            }
        }
        int[] ans = new int[count];
        for (int i = 0; i < s; i++) {
            ans[array[tMap1.get(students[i][0]) * 2][tMap2.get(students[i][1]) * 2]]++;
        }
        Arrays.sort(ans);
        System.out.println(ans[count - 1]);
    }
    public static boolean check (int x, int y, int xx, int yy) {
        if (x >= 0 && y >= 0 && x < xx * 2 && y < yy * 2) return true;
        return false;
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
    public static int gcd (int a, int b) {
        if (a == 1) return b;
        return gcd(b % a, a);
    }
}
