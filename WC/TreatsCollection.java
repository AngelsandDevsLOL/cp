package WC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreatsCollection {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int k = readInt();
        List<Long> aList1 = new ArrayList<>();
        List<Long> aList2 = new ArrayList<>();
        for (int i=0;i<n;i++) {
            long input = readInt();
            if (input < 0) {
                aList1.add(0,-1 * input);
            }else {
                aList2.add(input);
            }
        }
        if (aList1.size() == 0) {
            System.out.println(aList2.get(k-1));
        }else if (aList2.size() == 0) {
            System.out.println(aList1.get(k-1));
        }else {
            long sum = aList1.get(aList1.size()-1);
            long sum1 = aList2.get(aList2.size()-1);
            int count = 0;
            for (int i = aList1.size(); i < k; i++) {
                sum = sum + 2 * aList2.get(count);
                count++;
            }
            count = 0;
            for (int i = aList2.size(); i < k; i++) {
                sum1 = sum1 + 2 * aList1.get(count);
                count++;
            }
            long finalSum = sum1;
            long tempSum = sum;
            int num = Math.min(aList1.size(), aList2.size());
            for (int i = 0; i < num - 1; i++) { //left
                if (i != 0) {
                    tempSum = tempSum - (2 * aList2.get(i-1));
                }
                tempSum = tempSum + 2 * aList2.get(i);
                tempSum = tempSum - aList1.get(aList1.size()-i-1) + aList1.get(aList1.size()-i-2);
                if (tempSum < finalSum) {
                    finalSum = tempSum;
                }
                tempSum = sum;
            }
            tempSum = sum1;
            for (int i = 0; i < num - 1; i++) { //right
                if (i != 0) {
                    tempSum = tempSum - (2 * aList1.get(i-1));
                }
                tempSum = tempSum + 2 * aList1.get(i);
                tempSum = tempSum - aList2.get(aList2.size()-i-1) + aList2.get(aList1.size()-i-2);
                if (tempSum < finalSum) {
                    finalSum = tempSum;
                }
                tempSum = sum1;
            }
            System.out.println(finalSum);
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