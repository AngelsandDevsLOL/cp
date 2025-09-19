package COCI;

import java.util.*;
import java.io.*;

public class Dvoniz {
    public static void main(String[] args) throws IOException {
        int n = readInt(), s = readInt();
        Deque<Pair> deque = new LinkedList<>();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            int a = readInt();
            input[i] = a;
        }
        int sum = 0;
        int pointer = n - 1; // inclusive
        TreeMap<Integer, Integer> tMap = new TreeMap<>(); // index, num
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sum += input[i];
            for (; pointer >= i && sum > s; pointer--) {
                sum -= input[pointer];
            }
            int farthest = pointer - i + 1;
            // pointer = farthest + i - 1;
            while (!deque.isEmpty()) {
                Pair p = deque.peekFirst();
                if (p.a - i > p.b || pointer < p.a - 1) {
                    int num = p.a + p.b - 1;
                    if (tMap.get(num) == 1) tMap.remove(num);
                    else tMap.put(num, tMap.get(num) - 1);
                    deque.removeFirst();
                } else break;
            }
            // deque.addLast(new Pair(i, farthest));
            while (!deque.isEmpty()) {
                Pair p = deque.peekLast();
                int num = p.a + p.b - 1;
                if (num <= pointer) {
                    if (tMap.get(num) == 1) tMap.remove(num);
                    else tMap.put(num, tMap.get(num) - 1);
                    deque.removeLast();
                } else break;
            }
            if (deque.isEmpty() || tMap.isEmpty()) { // if tMap.isEmpty(), then deque should also be empty ...
                ans[i] = ((farthest / 2) * 2);
            } else {
                int x = tMap.floorKey(Integer.MAX_VALUE);
                ans[i] = (Math.max(Math.min(farthest * 2, (x - i + 1) / 2 * 2), 0));
            }
            if (farthest == 0) continue;

            deque.addLast(new Pair(i, farthest));
            if (tMap.containsKey(pointer)) tMap.put(pointer, tMap.get(pointer) + 1);
            else tMap.put(pointer, 1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }

    public static class Pair {
        int a;
        int b;

        public Pair(int aa, int bb) {
            a = aa;
            b = bb;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}
