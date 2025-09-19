package CCC;

import java.util.*;
import java.io.*;

public class LetterFrequency {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        String sentence = readLine();
        int queries = readInt();
        for (int i = 0; i < queries; i++) {
            String[] elements = readLine().split(" ");
            int start = Integer.parseInt(elements[0]);
            int end = Integer.parseInt(elements[1]);
            String find = elements[2];
            int count = 0;
            String string = sentence.substring(start-1, end);
            int index = string.indexOf(find);
            while (index != -1) {
                count++;
                index = string.indexOf(find, index + 1);
            }
            System.out.println(count);
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