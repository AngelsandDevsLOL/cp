package LCC;

import java.util.*;
import java.io.*;

public class GrahamsCandyPlanning {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("2.out"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] psa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int c = sc.nextInt() * (i % 2 == 1 ? 1 : -1);
            psa[i] += psa[i - 1] + c;
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt(), r = sc.nextInt();
            String output = in.readLine();
            if (Integer.parseInt(output) != psa[r] - psa[l - 1]) System.out.println(output);
        }
    }
}
