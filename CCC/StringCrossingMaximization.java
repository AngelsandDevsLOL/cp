package CCC;

import java.util.*;
import java.io.*;

public class StringCrossingMaximization {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        String s = readLine();
        String t = readLine();
        TreeMap<Integer, String> tMap = new TreeMap();
        int beforeCount = 0;
        for (int i = 0; i < k; i++) {
            String character = t.substring(i,i+1);
            int index = s.indexOf(character);
            ArrayList<Integer> aList = new ArrayList();
            while (index != -1) {
                aList.add(index);
                index = s.indexOf(character, index + 1);
            }
            beforeCount = beforeCount + aList.size();
            tMap.put(aList.size(), character);
        }
        int firstKey = tMap.firstKey();
        int count = 0;
        HashMap<String, Integer> hMap = new HashMap();
        for (int i = 0; i < n; i++) {
            String character = s.substring(i,i+1);
            if (hMap.containsKey(character)) {
                hMap.replace(character, hMap.get(character)+1);
                if (hMap.get(character) > count) {
                    count = hMap.get(character);
                }
            } else
                hMap.put(character, 1);
        }
        System.out.println(beforeCount-firstKey+count);
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