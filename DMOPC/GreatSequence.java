package DMOPC;

import java.util.*;
import java.io.*;

public class GreatSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        int q = readInt();
        int[] sumness = new int[n];
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
        int integer = 0;
        for (int i = 0; i < n; i++) {
            int x = readInt();
            sumness[i] = integer + x;
            integer = sumness[i];
            if (hMap.containsKey(x)) {
                hMap.get(x).add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                hMap.put(x, aList);
            }
        }
        boolean bool = true;
        for (int i = 0; i < q; i++) {
            int a = readInt();
            int b = readInt();
            int x = readInt()-1;
            int y = readInt()-1;
            int sum = sumness[y] - sumness[x];
            if (x > 0) {
                sum = sum + sumness[x] - sumness[x-1];
            } else {
                sum = sum + sumness[x];
            }
            if (sum < k) {
                bool = false;
                break;
            }
            ArrayList<Integer> aList = hMap.get(a);
            ArrayList<Integer> bList = hMap.get(b);
            boolean boola = false;
            for (int j = 0; j < aList.size(); j++) {
                if ((aList.get(j) <= y && aList.get(j) >= x)) {
                    boola = true;
                }
            }
            boolean boolb = false;
            for (int j = 0; j < bList.size(); j++) {
                if ((aList.get(j) <= y && aList.get(j) >= x)) {
                    boolb = true;
                    break;
                }
            }
            if (!(boolb && boola)) {
                bool = false;
            }
            if (bool) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
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