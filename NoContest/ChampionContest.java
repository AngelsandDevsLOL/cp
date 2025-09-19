package NoContest;

import java.io.*;
import java.util.*;

public class ChampionContest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        int[] ar = new int[n];
        HashMap<Integer, ArrayList<Integer>> friendships = new HashMap();
        HashMap<Integer, Integer> points = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ar[i] = readInt();
        }
        int[] array = ar.clone();
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            if (points.containsKey(array[i])) {
                continue;
            } else {
                points.put(array[i], i);
            }
        }
        for (int i = 0; i < k; i++) {
            int a = readInt();
            int b = readInt();
            if (ar[a-1] < ar[b-1]) {
                if (friendships.containsKey(b)) {
                    friendships.get(b).add(a);
                } else {
                    ArrayList<Integer> aList = new ArrayList<>();
                    aList.add(a);
                    friendships.put(b, aList);
                }
            } else {
                if (friendships.containsKey(a)) {
                    friendships.get(a).add(b);
                } else {
                    ArrayList<Integer> aList = new ArrayList<>();
                    aList.add(b);
                    friendships.put(a, aList);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int wins = points.get(ar[i]);
            ArrayList<Integer> aList = friendships.get(i+1);
            int size;
            if (aList == null) {
                size = 0;
            } else {
                size = aList.size();
            }
            System.out.print((wins - size) + " ");
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

