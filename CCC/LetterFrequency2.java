package CCC;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LetterFrequency2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {

        String sentense = readLine();
        int queries= readInt();

        int[] lastCount=new int[26];
        TreeMap<Integer,Integer>[] maps=new TreeMap[26];

        for (int i=0;i<sentense.length();i++) {
            char ch=sentense.charAt(i);
            if (ch==' ') {
                continue;
            }
            int index=ch -'a';
            lastCount[index]++;
            TreeMap<Integer,Integer> treeMap=maps[index];
            if (treeMap==null) {
                treeMap=new TreeMap<Integer,Integer>();
                maps[index]=treeMap;
            }
            treeMap.put(i,lastCount[index]);
        }

        for (int i=0;i<queries;i++) {





            int start=readInt()-1;
            int end=readInt()-1;

            char letter=  readCharacter();
            int index=letter -'a';
            TreeMap<Integer,Integer> treeMap=maps[index];
            int count = 0;
            if (treeMap!=null) {
                Map.Entry<Integer, Integer> startEntry = treeMap.ceilingEntry(start);
                Map.Entry<Integer, Integer> endEntry = treeMap.floorEntry(end);

                if (startEntry != null && endEntry != null) {
                    count = endEntry.getValue() - startEntry.getValue()+1;
                }
            }

            System.out.println(count);
        }
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static int[] convert (String[] in) {
        int[] out = new int[in.length - 1];
        for (int i = 1; i < in.length; i++) out[i - 1] = Integer.parseInt(in[i]);
        return out;
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