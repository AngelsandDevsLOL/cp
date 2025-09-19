package LCC;

import java.util.*;
import java.io.*;

public class SplittingCandy {
    public static void  method1 (int x) throws IOException {
        PrintWriter in = new PrintWriter(new FileWriter(x + ".in"));
        PrintWriter out = new PrintWriter(new FileWriter(x + ".out"));
        int n = (int) (Math.random() * (10)) + 1;
        int m = (int) (Math.random() * (10 - n) + n);
        int q = (int) (Math.random() * 10) + 1;
        in.println(n + " " + m + " " + q);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if ((int) (Math.random() * 2) == 0) sb.append("0");
            else sb.append("1");
        }
        String input = sb.toString();
        in.println(input);
        int[] psa = new int[m + 1];
        int[] lastIndex = new int[(int) 1e6];
        Arrays.fill(lastIndex, -1);
        psa[0] = (int) 1e5;
        for (int i = 0; i < m; i++) {
            if (input.charAt(i) == '0') {
                psa[i + 1] += psa[i] - 1;
            } else {
                psa[i + 1] += psa[i] + 1;
            }
            lastIndex[psa[i + 1]] = i;
        }
        for (int i = 0; i < q; i++) {
            int index = (int) (Math.random() * m);
            in.println(index);
            System.out.println(lastIndex[psa[index]] - index + 1);
            out.println(lastIndex[psa[index]] - index + 1);
        }
        out.close();
        in.close();
    }
    public static void main (String[] args) throws IOException {
        for (int i = 1; i <= 20; i++) {
            method1(i);
        }
    }
}


