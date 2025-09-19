package DMOPC;

import java.io.*;
import java.util.*;

public class Japaneasy {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        HashSet<String> hSet = new HashSet();
        hSet.add("a");
        hSet.add("e");
        hSet.add("i");
        hSet.add("o");
        hSet.add("u");
        hSet.add("ka");
        hSet.add("ki");
        hSet.add("ku");
        hSet.add("ke");
        hSet.add("ko");
        hSet.add("na");
        hSet.add("ne");
        hSet.add("nu");
        hSet.add("no");
        hSet.add("ni");
        hSet.add("ha");
        hSet.add("he");
        hSet.add("fu");
        hSet.add("hi");
        hSet.add("ho");
        hSet.add("ma");
        hSet.add("mi");
        hSet.add("mu");
        hSet.add("me");
        hSet.add("mo");
        hSet.add("ra");
        hSet.add("ri");
        hSet.add("ru");
        hSet.add("re");
        hSet.add("ro");
        int x = readInt();
        for (int i = 0; i < x; i++) {
            String input = readLine();
            boolean bool = true;
            int var = 0;
            while (!input.equals("") && bool) {
                String num = input.substring(var,var+1);
                if (hSet.contains(num)) {
                    var++;
                } else if (input.length() > 1 && hSet.contains(input.substring(var,var+2))) {
                    var = var + 2;
                } else {
                    bool = false;
                }
            }
            if (bool) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
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

