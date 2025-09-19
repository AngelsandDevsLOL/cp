package CCC.Senior;
import java.util.*;
import java.io.*;
public class TintedGlassWindow {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int N = readInt(), T = readInt();
        int [] l = new int[N], r = new int[N], t = new int[N], b = new int[N], v = new int[N];
        TreeMap<Integer, Integer> cx = new TreeMap(), cy = new TreeMap();
        List<Integer> rx = new ArrayList(), ry = new ArrayList();
        for(int i=0; i<N; i++) {
            l[i] = readInt(); t[i] = readInt(); r[i] = readInt(); b[i] = readInt(); v[i] = readInt();
            cx.put(l[i], 0); cx.put(r[i], 0); cy.put(t[i], 0); cy.put(b[i], 0);
        }
        int idx = 0;
        for(Map.Entry<Integer, Integer> x : cx.entrySet()) { x.setValue(++idx); rx.add(x.getKey()); }
        idx = 0;
        for(Map.Entry<Integer, Integer> y : cy.entrySet()) { y.setValue(++idx); ry.add(y.getKey()); }
        int[][] dif = new int[cx.size() + 1][cy.size() + 1];
        for(int i=0; i<N; i++) {
            int r1 = cx.get(l[i]), c1 = cy.get(t[i]), r2 = cx.get(r[i]), c2 = cy.get(b[i]);
            dif[r1][c1] += v[i];   dif[r1][c2] -= v[i];
            dif[r2][c1] -= v[i];   dif[r2][c2] += v[i];
        }
        long ans = 0;
        for(int i=1; i<cx.size(); i++) {
            for(int j=1; j<cy.size(); j++) {
                dif[i][j] += dif[i-1][j] + dif[i][j-1] - dif[i-1][j-1];
                if(dif[i][j] >= T) ans += (long)(rx.get(i) - rx.get(i-1))*(ry.get(j) - ry.get(j-1));
            }
        }
        System.out.println(ans);
    }
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