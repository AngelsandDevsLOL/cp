package Random;

import java.io.*;
import java.util.*;

public class GGG {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException {
        int n = readInt();
        int[] ar = new int[1000001];
        Arrays.fill(ar, -1);
        for (int i = 0; i < n; i++) {
            ar[readInt()] = i;
        }
        int i = readInt();
        int[] input2 = new int[i];
        ArrayList<Integer> aList = new ArrayList<>(); aList.add(0);
        int length = 0;
        for (int j = 0; j < i; j++) {
            input2[j] = readInt();
            if (ar[input2[j]] != -1) {
                int x = ar[input2[j]];
                int index = binarySearch(length, x, aList);
                if (index == length) {
                    aList.add(x);
                    length++;
                } else {
                    aList.set(index + 1, x);
                }
            }
        }
        System.out.println(aList.size() - 1);
    }
    public static int binarySearch(int size, int n, ArrayList<Integer> aList) {
        int low = 0;
        int high = size;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(aList, mid, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean check(ArrayList<Integer> aList, int index, int n) {
        if (aList.get(index) < n) {
            return true;
        }
        return false;
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
