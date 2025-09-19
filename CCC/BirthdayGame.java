package CCC;

import java.util.*;
import java.io.*;

public class BirthdayGame {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int count = 200000;
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap();
        for (int i = 0; i < n; i++) {
            int input = readInt();
            if (hMap.containsKey(input)) {
                ArrayList<Integer> aList = hMap.get(input);
                if (i - aList.get(aList.size()-1) < count) {
                    count = i - aList.get(aList.size()-1);
                }
                hMap.get(input).add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                hMap.put(input, aList);
            }
        }
        System.out.println(count+1);
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
    public static  void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[columnNumber-1] > second[columnNumber-1]) return 1;
                else return -1;
            }
        });
    }
}