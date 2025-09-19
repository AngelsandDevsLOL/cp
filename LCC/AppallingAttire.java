package LCC;

        import java.io.*;
        import java.util.*;

public class AppallingAttire {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {        Scanner scanner = new Scanner(System.in);
        int n = readInt();
        int m = readInt();
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = readInt();
            if (tMap.containsKey(x)) {
                tMap.put(x, tMap.get(x) + 1);
            } else {
                tMap.put(x, 1);
            }
        }
        HashMap<Integer, Integer> rankings = new HashMap<>();
        int count = n;
        for (int i : tMap.keySet()) {
            count = count - tMap.get(i);
            rankings.put(i, count);
        }
        for (int i = 0; i < m; i++) {
            int friend = readInt();
            System.out.println(rankings.get(friend) + 1);
        }
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
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
