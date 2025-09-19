package CCC;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BobsTeam2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        TreeMap<Integer, Integer> level1Map = new TreeMap<>();
        TreeMap<Integer, Long> level2Map = new TreeMap<>();

        int levels[][] = new int[3][n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                levels[i][j] = readInt();
            }
        }

        Arrays.sort(levels[0]);
        Arrays.sort(levels[1]);
        for (int i = 0; i < n; i++) {
            level1Map.put(levels[0][i], i + 1);
        }
        long level2Count = 0;
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> level1Entry = level1Map.floorEntry(levels[1][i] - 1);
            if (level1Entry != null) {
                level2Count = level2Count + level1Entry.getValue();
            }
            level2Map.put(levels[1][i], level2Count);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            int level3 = levels[2][i];
            Map.Entry<Integer, Long> level2Entry = level2Map.floorEntry(level3 - 1);
            if (level2Entry == null) {
                continue;
            }

            count = count + level2Entry.getValue();

        }
        System.out.println(count);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}