package CCC.Senior;

import java.util.*;
import java.io.*;
// I SWEAR I CODED THE EXACT SAME DURING THE CCC AND IT DIDN'T FUCKING WORK AHHHHHHHHHHH
public class PrettyPens {
    public static void main (String[] args) throws IOException {
        int n = readInt(), m = readInt(), q = readInt();
        TreeMap<Integer, Integer>[] input = new TreeMap[m + 1];
        for (int i = 1; i <= m; i++) {
            input[i] = new TreeMap<>();
        }
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; i++) {
            int c = readInt(), p = readInt();
            ar[i][0] = c; ar[i][1] = p;
            add(input[c], p);
        }
        TreeMap<Integer, Integer> best = new TreeMap<>();
        TreeMap<Integer, Integer> second = new TreeMap<>();
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            int num = input[i].floorKey(Integer.MAX_VALUE);
            add(best, num);
            ans += num;
            if (input[i].get(num) == 1 && input[i].size() != 1) {
                add(second, input[i].lowerKey(num));
            } else if (input[i].get(num) == 1) {

            } else add(second, num);
        }
        if (!second.isEmpty() && best.ceilingKey(0) < second.floorKey(Integer.MAX_VALUE)) {
            System.out.println(ans - best.ceilingKey(0) + second.floorKey(Integer.MAX_VALUE));
        } else System.out.println(ans);
        for (int i = 0; i < q; i++) {
            int query = readInt(), index = readInt() - 1, change = readInt();
            if (query == 1) { // change colour ...
                int prev = ar[index][0];
                ar[index][0] = change; // new colour !

                int oldBest = input[prev].floorKey(Integer.MAX_VALUE);
                int oldSecond = oldBest;
                if (input[prev].get(oldBest) == 1 && input[prev].size() != 1) {
                    oldSecond = input[prev].lowerKey(oldBest);
                    remove(second, oldSecond);
                } else if (input[prev].get(oldBest) == 1) { // only 1 max +

                } else remove(second, oldSecond);

                remove(best, oldBest);
                ans -= oldBest;

                int oldBest2 = input[change].floorKey(Integer.MAX_VALUE);
                int oldSecond2 = oldBest2;
                if (input[change].get(oldBest2) == 1 && input[change].size() != 1) {
                    oldSecond2 = input[change].lowerKey(oldBest2);
                    remove(second, oldSecond2);
                } else if (input[change].get(oldBest2) == 1) {

                } else remove(second, oldSecond2);

                remove(best, oldBest2);
                ans -= oldBest2;

                remove(input[prev], ar[index][1]); // remove from old colour
                add(input[change], ar[index][1]); // add to new colour

                int Best = input[prev].floorKey(Integer.MAX_VALUE);
                int Second = Best;
                if (input[prev].get(Best) == 1 && input[prev].size() != 1) {
                    Second = input[prev].lowerKey(Best);
                    add(second, Second);
                } else if (input[prev].get(Best) == 1) {

                } else {
                    add(second, Second);
                }
                add(best, Best);

                ans += Best;

                int Best2 = input[change].floorKey(Integer.MAX_VALUE);
                int Second2 = Best2;
                if (input[change].get(Best2) == 1 && input[change].size() != 1) {
                    Second2 = input[change].lowerKey(Best2);
                    add(second, Second2);
                } else if (input[change].get(Best2) == 1) {

                } else {
                    add(second, Second2);
                }
                add(best, Best2);

                ans += Best2;
            } else if (query == 2) { // change prettiness ...
                int prev = ar[index][1]; // the old prettiness
                int colour = ar[index][0];
                ar[index][1] = change; // new prettiness !

                int oldBest = input[colour].floorKey(Integer.MAX_VALUE);
                int oldSecond = oldBest;
                if (input[colour].get(oldBest) == 1 && input[colour].size() != 1) {
                    oldSecond = input[colour].lowerKey(oldBest);
                    remove(second, oldSecond);
                } else if (input[colour].get(oldBest) == 1) {

                } else remove(second, oldSecond);

                remove(best, oldBest);
                ans -= oldBest;

                remove(input[colour], prev); // remove old prettiness !
                add(input[colour], change); // add new prettiness !

                int Best = input[colour].floorKey(Integer.MAX_VALUE);
                int Second = Best;
                if (input[colour].get(Best) == 1 && input[colour].size() != 1) {
                    Second = input[colour].lowerKey(Best);
                    add(second, Second);
                } else if (input[colour].get(Best) == 1) {

                } else {
                    add(second, Second);
                }
                add(best, Best);
                ans += Best;
            }
             // do the thing
            if (!second.isEmpty() && best.ceilingKey(0) < second.floorKey(Integer.MAX_VALUE)) {
                System.out.println(ans - best.ceilingKey(0) + second.floorKey(Integer.MAX_VALUE));
            } else System.out.println(ans);
        }
    }
    public static void add (TreeMap<Integer, Integer> tMap, int index) {
        if (tMap.containsKey(index)) tMap.put(index, tMap.get(index) + 1);
        else tMap.put(index, 1);
    }
    public static void remove (TreeMap<Integer, Integer> tMap, int index) {
        if (tMap.get(index) == 1) tMap.remove(index);
        else tMap.put(index, tMap.get(index) - 1);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    static int mod = (int) 1e9+7;

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
    static int readLongLineInt() throws IOException{
        int x = 0, c;
        while((c = br.read()) != ' ' && c != '\n')
            x = x * 10 + (c - '0');
        return x;
    }
    static long pow (long x, long exp){
        if (exp==0) return 1;
        long t = pow(x, exp/2);
        t = t*t %mod;
        if (exp%2 == 0) return t;
        return t*x%mod;
    }
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
