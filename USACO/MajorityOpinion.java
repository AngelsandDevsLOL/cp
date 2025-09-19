
import java.util.*;
import java.io.*;

public class MajorityOpinion {
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
    public static void main (String[] args) throws IOException {
        int t = readInt();
        for (int i = 0; i < t; i++) {
            int n = readInt();
            ArrayList<int[]> aList = new ArrayList<int[]>();
            int prev = 0;
            int count = 1;
            TreeSet<Integer> ans = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                int input = readInt();
                if (prev == 0) {
                    prev = input;
                } else if (prev == input) {
                    count++;
                } else {
                    aList.add(new int[]{prev, count});
                    if (count > 1) ans.add(prev);
                    prev = input;
                    count = 1;
                }
            }
            aList.add(new int[]{prev, count});
            if (count > 1) ans.add(prev);
            for (int j = 0; j < aList.size() - 2; j++) {
                if (aList.get(j)[0] == aList.get(j + 2)[0] && aList.get(j + 1)[1] == 1) {
                    ans.add(aList.get(j)[0]);
                }
            }
            if (ans.size() == 0) {
                System.out.println(-1);
            } else {
                int num = 0;
                for (int x : ans) {
                    if (num++ == ans.size() - 1) System.out.println(x);
                    else System.out.print(x + " ");
                }
            }
        }
    }
}
