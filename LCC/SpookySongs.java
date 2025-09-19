package LCC;

import java.io.*;
import java.util.*;

public class SpookySongs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int q = readInt();
        ArrayList[] module = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            module[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            int x = readInt();
            module[x % 4].add(i);
        }
        ArrayList[] aList2 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            aList2[i] = new ArrayList();
        }
        ArrayList<Integer> aList = module[0];

        for (int k = 0; k < aList.size(); k++) {
            for (int l = k + 1; l < aList.size(); l++) {
                aList2[aList.get(k)].add(aList.get(l));
            }

        }
        aList = module[1];
        ArrayList<Integer> aList3 = module[3];
        for (int k = 0; k < aList.size(); k++) {
            for (int l = 0; l < aList3.size(); l++) {
                aList2[aList.get(k)].add(aList3.get(l));
            }
        }
        aList = module[2];
        for (int k = 0; k < aList.size(); k++) {
            for (int l = k + 1; l < aList3.size(); l++) {
                aList2[aList.get(k)].add(aList.get(l));
            }
        }
        for (int i = 0; i < q; i++) {
            int a = readInt() - 1;
            int b = readInt() - 1;
            int count = 0;
            for (int j = a; j <= b; j++) {
                ArrayList<Integer> al = aList2[a];
                Collections.sort(al);
                int index = binarySearch(al, 0, al.size()-1, b);
                count = count + index;
            }
            System.out.println(count);
        }
    }
    public static int binarySearch(ArrayList<Integer>arr, int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr.get(mid) == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present
        // in array
        return l + (r - l) / 2;
    }

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