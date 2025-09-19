package COCI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class vrsar {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<int[]> aList = new ArrayList<>();
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int hill = sc.nextInt();
                hSet.add(hill);
                aList.add(new int[]{hill, sc.nextInt(), sc.nextInt()});
            }
        }
        int[] testCase = new int[m];
        for (int i = 0; i < m; i++) {
            int input = sc.nextInt();
            testCase[i] = input;
            if (!hSet.contains(input)) {
                aList.add(new int[]{input, 0, 0});
            }
        }
        Collections.sort(aList, (x, y) -> Integer.compare(x[0], y[0]));
        int[][] ar = new int[hSet.size()][3];
        int[] edge = new int[hSet.size()];
        for (int i = 0; i < aList.size(); i++) {
            ar[i] = aList.get(i);
            if (i != 0) {
                edge[i - 1] = ar[i][0] - ar[i - 1][0];
            }
        }
        for (int i = 0; i < m; i++) {

        }
    }
}
