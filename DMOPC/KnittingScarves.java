package DMOPC;

import java.util.*;
import java.io.*;

public class KnittingScarves {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int q = readInt();
        LinkedList<String> list=new LinkedList<String>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        for (int i = 0; i < q; i++) {
            int l = readInt();
            int r = readInt();
            int k = readInt();
            int index1 = list.indexOf(String.valueOf(l));
            int index2 = list.indexOf(String.valueOf(r));
            ArrayList<String> aList = new ArrayList<>();
            if (k < index1) {
                for (int j = 0; j < (index2 - index1 + 1); j++) {
                    aList.add(list.get(index1));
                    list.remove(index1);
                }
                for (int j = k; j < k + (index2 - index1 + 1); j++) {
                    list.add(j, aList.get(j - k));
                }
            } else if (k > index1){
                for (int j = 0; j < (index2 - index1 + 1); j++) {
                    aList.add(list.get(index1));
                    list.add(j, aList.get(j - k));

                }
                for (int j = k; j < k + (index2 - index1 + 1); j++) {
                    list.add(j, aList.get(j - k));
                }
                for (int j = 0; j < index2 - index1 + 1; j++) {
                    list.remove(index1);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
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