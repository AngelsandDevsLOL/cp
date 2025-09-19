package CCC;

import java.util.*;
import java.io.*;

public class MusicalChairs {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String args[]) throws IOException {
        int n = readInt();
        int k = readInt();
        int[] chairs = new int[n];
        int[] students = new int[k+1];
        for (int i = 0; i < k; i++) {
            int x = readInt();
            chairs[x-1] = 1;
        }
        for (int i = 0; i < k+1; i++) {
            students[i] = readInt()-1;
        }
        int withoutChair = k+1;
        while ( withoutChair>1){
            for (int i = 0; i <k+1; i++) {
                int y = students[i];
                if (y==-1) continue; //already sat
                if ( chairs[y] == 1){ // found a chair, then sat
                    chairs[students[i]] = -1;
                    students[i] = -1;
                    withoutChair--;
                }else  {  // move to next one
                    if (y==n-1) {
                        y=0;
                    }else {
                        y++;
                    }
                    students[i]=y;
                }
            }
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] != -1){
                System.out.println(i+1);
            }
        }
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
        return st.nextToken();
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
