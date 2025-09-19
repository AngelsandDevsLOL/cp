package CCC;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ARangeMaxQueryProblem2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int q = readInt();
        int p = readInt();

        int ai = 0;
        ArrayList<Integer> aList = new ArrayList<>(q);
        TreeMap<Integer, int[]> queryMap=new TreeMap<>();
        int maxNumber=0;
        int maxIndex=0;

        for (int i = 0; i < q; i++) {
            char command=readCharacter();
            int value=readInt();

            if (command=='A') {
                int num = value ^ ai;
                aList.add(num);
                if (maxNumber<=num) {
                    maxNumber=num;
                    maxIndex=aList.size()-1;

                }
            } else {
                int number = value ^ ai;
                int count = 0;
                if (number< aList.size() -maxIndex) {
                    int startIndex = aList.size() - number;
                    int j=startIndex;
                    int nextHop=-1;
                    Map.Entry<Integer, int[]> entry=null;
                    while (  j < aList.size() ) {
                        if (j> nextHop) {
                            entry = queryMap.ceilingEntry(j);
                            if (entry != null) {
                                nextHop=entry.getKey();
                            }else {
                                nextHop=  aList.size()+1;
                            }
                        }
                        if (j==nextHop){
                            int[] query=entry.getValue();
                            if (query[1] >count) {
                                count=query[1];
                            }
                            j=query[0];
                        }else {
                            int num = aList.get(j);
                            if (num > count) {
                                count = num;
                            }
                            j++;
                        }
                    }
                    int[] search= {aList.size(),count};
                    queryMap.put(startIndex,search);

                }else {
                    count=maxNumber;
                }

                ai=count;
                System.out.println(count);
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