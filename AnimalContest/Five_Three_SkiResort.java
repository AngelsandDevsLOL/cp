package AnimalContest;

import java.util.*;
import java.io.*;

public class Five_Three_SkiResort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        int[] array = new int[n]; //hills
        array[0] = k;
        HashMap<Integer, HashMap<Integer, Integer>> hMap = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int a = readInt(); // beginning
            int b = readInt(); // ending
            int d = readInt(); // difficiulty
            if (hMap.containsKey(a)) {
                HashMap<Integer, Integer> hashMap = hMap.get(a);
                hashMap.put(d, b);
                hMap.replace(a, hashMap);
            } else {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap.put(d, b);
                hMap.put(a, hashMap);
            }
        }
        for (int i = 0; i < k; i++) {
            boolean bool = true;
            int place = 1; // current place
            int dpanda = readInt();
            while (bool) {
                if (hMap.containsKey(place)) {
                    HashMap<Integer, Integer> hashMap = hMap.get(place);
                    int number = Integer.MAX_VALUE; // difference to closest difficulty
                    for (int integer : hashMap.keySet()) { //(difficulty, end product)
                        if (Math.abs(integer - dpanda) < number) {
                            number = Math.abs(integer - dpanda);
                        }
                    }
                    if (hashMap.containsKey(dpanda - number)) {
                        place = hashMap.get(dpanda - number);
                    } else {
                        place = hashMap.get(dpanda + number);
                    }
                    array[place - 1]++;
                } else {
                    bool = false;
                }
            }
        }
        String string = "";
        for (int i = 0; i < n; i++) {
            string = string + " " + array[i];
        }
        System.out.println(string.trim());
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