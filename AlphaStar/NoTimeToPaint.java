package AlphaStar;

import java.util.*;
import java.io.*;

public class NoTimeToPaint {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt(), q = readInt();
        String input = readLine();
        int[] prefix = new int[n + 2];
        int[] suffix = new int[n + 2];
        Stack<Character> prestack = new Stack<>();
        Stack<Character> sufstack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int temp = i - 1;
            if (prestack.isEmpty() || input.charAt(temp) > prestack.peek()) {
                prestack.add(input.charAt(temp));
                prefix[i]++;
            } else if (input.charAt(temp) < prestack.peek()) {
                while (!prestack.isEmpty() && input.charAt(temp) < prestack.peek()) {
                    prestack.pop();
                }
                if (prestack.isEmpty() || prestack.peek() < input.charAt(temp)) {
                    prestack.add(input.charAt(temp));
                    prefix[i]++;
                }
            }
            prefix[i] += prefix[temp];
            temp = n - i;
            if (sufstack.isEmpty() || input.charAt(temp) > sufstack.peek()) {
                sufstack.add(input.charAt(temp));
                suffix[temp + 1]++;
            } else if (input.charAt(temp) < sufstack.peek()) {
                while (!sufstack.isEmpty() && input.charAt(temp) < sufstack.peek()) {
                    sufstack.pop();
                }
                if (sufstack.isEmpty() || input.charAt(temp) > sufstack.peek()) {
                    sufstack.push(input.charAt(temp));
                    suffix[temp + 1]++;
                }
            }
            suffix[temp + 1] += suffix[temp + 2];
        }
        for (int i = 0; i < q; i++) {
            int a = readInt() - 1, b = readInt() + 1;
            System.out.println(prefix[a] + suffix[b]);
        }
    }
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
