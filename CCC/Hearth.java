package CCC;

import java.util.*;
import java.io.*;
public class Hearth {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt(), t = readInt();
        card a[] = new card[n];
        for (int i = 0; i < n; i++) {
            a[i] = new card(next(), readInt());
        }
        Arrays.sort(a, (x, y) -> x.name.compareTo(y.name));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i].mana + a[j].mana + a[k].mana <= t){
                        System.out.println(a[i].name + " " + a[j].name + " " + a[k].name);
                    }
                }
            }
        }
    }
    static class card {
        String name; int mana;
        card (String n, int m) { name = n; mana = m;}
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