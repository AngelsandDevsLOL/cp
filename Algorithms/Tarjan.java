package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarjan {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            aList[x].add(y);
        }
        //dfs(-1, 1, aList, );
    }
    //public static void dfs (int root, int cur, ArrayList<Integer>[], int[] disc, int[] low) {

    //}
}
