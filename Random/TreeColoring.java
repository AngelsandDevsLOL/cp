package Random;

import java.io.*;
import java.util.*;

public class TreeColoring {
    static int[] array;
    static boolean[] bool2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int num = readInt() - 1;
        array = new int[num+1];
        bool2 = new boolean[num+1];
        HashMap<Integer, ArrayList<Integer>> same = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> dif = new HashMap<>();
        int u = readInt();
        int v = readInt();
        int w = readInt();
        if (w % 2 == 0) {
            array[u - 1] = 1;
            array[v - 1] = 1;
            ArrayList<Integer> aList = new ArrayList();
            aList.add(u);
            same.put(v, aList);
            ArrayList<Integer> aList2 = new ArrayList();
            aList2.add(v);
            same.put(u, aList2);
        } else {
            array[v - 1] = 1;
            ArrayList<Integer> aList = new ArrayList();
            aList.add(u);
            dif.put(v, aList);
            ArrayList<Integer> aList2 = new ArrayList();
            aList2.add(v);
            dif.put(u, aList2);
        }
        for (int i = 0; i < num - 1; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();
            if (c % 2 == 0) {
                if (same.containsKey(a)) {
                    same.get(a).add(b);
                } else {
                    ArrayList<Integer> alist = new ArrayList<>();
                    alist.add(b);
                    same.put(a, alist);
                }
                if (same.containsKey(b)) {
                    same.get(b).add(a);
                } else {
                    ArrayList<Integer> alist = new ArrayList<>();
                    alist.add(a);
                    same.put(b, alist);
                }
            } else {
                if (dif.containsKey(a)) {
                    dif.get(a).add(b);
                } else {
                    ArrayList<Integer> alist = new ArrayList<>();
                    alist.add(b);
                    dif.put(a, alist);
                }
                if (dif.containsKey(b)) {
                    dif.get(b).add(a);
                } else {
                    ArrayList<Integer> alist = new ArrayList<>();
                    alist.add(a);
                    dif.put(b, alist);
                }
            }
        }
        recursion(same, dif, u);
        recursion(same, dif, v);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    static void recursion (HashMap<Integer, ArrayList<Integer>> same, HashMap<Integer, ArrayList<Integer>> dif, int num) {
        if (bool2[num - 1]) {
            return;
        }
        bool2[num - 1] = true;
        ArrayList<Integer> asame;
        if (same.containsKey(num)) {
            asame = same.get(num);
            for (int i = 0; i < asame.size(); i++) {
                array[asame.get(i)-1]=array[num-1];
                recursion(same, dif, asame.get(i));
            }
        }
        if (dif.containsKey(num)) {
            asame = dif.get(num);
            for (int i = 0; i < asame.size(); i++) {
                int x = array[num-1];
                if (x == 0) {
                    array[asame.get(i)-1] = 1;
                } else {
                    array[asame.get(i)-1] = 0;
                }
                recursion(same, dif, asame.get(i));
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
