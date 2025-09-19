package NoContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main (String[] args) throws IOException {
        int n = readInt();
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(0);
        for (int i = 0; i < n; i++) {
            int input = readInt();
            if (input > aList.get(aList.size() - 1)) {
                aList.add(input);
            } else {
                int index = binarySearch(aList, input);
                aList.remove(index + 1);
                aList.add(index + 1, input);
            }
        }
        System.out.println(aList.size() - 1);
    }
    public static int binarySearch (ArrayList<Integer> aList, int input) {
        int low = 0;
        int high = aList.size()-1;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(aList, mid, input)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean check (ArrayList<Integer> aList, int mid, int input) {
        if (aList.get(mid) < input) {
            return true;
        }
        return false;
    }
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}