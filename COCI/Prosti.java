package COCI;

import java.io.*;
import java.util.*;

public class Prosti {
    public static void main (String[] args) throws IOException {
        int q = readInt();
        int[] primes = sieve();
        for (int i = 0; i < q; i++) {
            int k = readInt(), l = readInt(), m = readInt();
            if (k > m && primes[k] - primes[m] + m < l) System.out.println(-1);
            else if (primes[(int)1e7 + k - 1] - primes[(int)1e7 - 1] > l) System.out.println(-1);
            else if (primes[(int)1e7 + k - 1] - primes[(int)1e7 - 1] == l) System.out.println((int)1e7);
            else System.out.println(bsearch(1, (int) 1e7, primes, k, l, m));
        }
    }
    public static int[] sieve () {
        int[] prime = new int[(int) 1e7 + 152];
        int count = 1;
        prime[2] = 1;
        for (int i = 3; i < prime.length - 1; i += 2) {
            if (prime[i] == -1) prime[i] = count;
            else {
                prime[i] = ++count;
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = -1;
                }
            }
            prime[i + 1] = count;
        }
        return prime;
    }
    public static int bsearch (int low, int high, int[] prime, int k, int l, int m) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = 0;
            if (mid > m) val = prime[mid + k - 1] - prime[mid - 1];
            else val = prime[mid + k - 1] - prime[m] + (m - mid + 1);
            if (val > l) {
                low = mid + 1;
                ans = mid;
            } else if (val < l) {
                high = mid - 1;
            } else return mid;
        }
        return ans;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
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