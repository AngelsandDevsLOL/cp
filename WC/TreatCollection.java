package WC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreatCollection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k=readInt();
        List<Long> listLeft=new ArrayList<>();
        List<Long> listRight=new ArrayList<>();

        for (int i=0;i<n;i++) {
            long x=readInt();
            if (x<0) {
                listLeft.add(0,-1*x);
            }else {
                listRight.add(x);
            }
        }
        if (listLeft.size()==0) {
            System.out.println( listRight.get(k-1));
        }else if (listRight.size()==0) {
            System.out.println( listLeft.get(k-1));
        }else {
            long distance1 = getDistance(listLeft, listRight, k);
            long distance2 = getDistance(listRight, listLeft, k);

            System.out.println(Math.min(distance1, distance2));
        }
    }
    private static long getDistance(List<Long> firstList, List<Long> secondList, int k) {
        long distance=0;
        int count=0;
        int firstIndex=Math.min(k,firstList.size())-1;
        distance = firstList.get(firstIndex);
        count = firstIndex + 1;

        int secondIndex=0;
        if (count<k) {
            secondIndex = k-count-1;
            distance= distance+ 2*secondList.get(secondIndex);
            secondIndex++;
        }

        int maxIndex=Math.min(k-1, secondList.size());

        for (int i=secondIndex; i<maxIndex;i++){
            firstIndex--;
            long newDistance=0;
            if (firstIndex>=0) {
                newDistance=   firstList.get(firstIndex)+ 2*secondList.get(i);
            }else {
                newDistance=    secondList.get(i);
            }
            if (distance>newDistance) {
                distance=newDistance;
            }
            if (firstIndex<0) {
                return distance;
            }

        }
        return distance;

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