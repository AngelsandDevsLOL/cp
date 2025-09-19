package Random;

import java.io.*;
import java.util.*;

public class AssignmentOfTheYear {
    static int c = 0;
    static int length;
    static int m;
    static HashSet<Long>  mySet=new HashSet<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = readInt();
        length = n;
        m = readInt();
        readLine();
        String input = readLine();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.substring(i, i+1);
        }
        recursion(input.substring(0,1), 1, array);
        System.out.println(c);
    }
    static void recursion (String input, int num, String[] array) {
        if (num == length) {
            String[] ar = input.split(" ");
            long count = 0;
            for (int i = 0; i < ar.length; i++) {

                count = count + Long.parseLong(ar[i]);
                if (count>=m) {
                    return;
                }

            }
            if (count >= m) {
                return;
            }

            if (mySet.contains(  count )) {
                return;
            } else {
                mySet.add(count);
                c++;
                return;
            }
        } else {
            recursion (input + " " + array[num], num + 1, array);
            recursion (input + array[num], num + 1, array);
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
