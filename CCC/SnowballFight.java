package CCC;

import java.util.*;
import java.io.*;

public class SnowballFight {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int t = readInt();
        HashMap<Integer, ArrayList> targetList = new HashMap();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int person = readInt();
            array[i] = person;
            if (targetList.containsKey(person)) {
                ArrayList<Integer> aList = targetList.get(person);
                aList.add(i + 1);
                targetList.replace(person, aList);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i + 1);
                targetList.put(person, aList);
            }
        }
        HashMap<Integer, ArrayList> target = targetList;
        for (int i = 1; i < t; i++) {
            for (int j = 1; j <= n; j++) {
                ArrayList<Integer> aList = targetList.get(j);
                if (aList != null && aList.size() != 0) {
                    int targets = aList.get(0);
                    ArrayList<Integer> aList2 = new ArrayList<>();
                    for (int k = 1; k < aList.size(); k++) {
                        aList2.add(aList.get(k));
                    }
                    targetList.replace(j, aList2);
                    target.replace(j, aList2);
                    ArrayList<Integer> aList3 = targetList.get(targets);
                    if (aList3 == null) {
                        ArrayList<Integer> aList4 = new ArrayList();
                        aList3 = aList4;
                    }
                    aList3.add(j);
                    target.replace(targets, aList3);
                    array[j-1] = targets;
                }
            }
            targetList = target;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
            if (i != n-1) {
                System.out.print(" ");
            }
        }
        System.out.println();
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