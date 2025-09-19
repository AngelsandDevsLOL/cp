package IOI;

import COCI.Hash;

import java.util.*;

public class CarParking {
    public static TreeMap<Integer, ArrayList<ArrayList<Integer>>> cycles = new TreeMap<>();
    public static boolean[] vis;
    public static int[] next;
    public static int[] input;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), w = sc.nextInt();
        int[] groups = new int[m];
        vis = new boolean[n];
        next = new int[m];
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            groups[input[i]]++;
        }
        for (int i = 1; i < m; i++) {
            groups[i] += groups[i - 1];
            next[i] = groups[i - 1];
        }
        int group = 1;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                recurs(group, new boolean[m], new ArrayList<>());
            }
        }
        StringBuilder ans = new StringBuilder();
        int num = 0;
        for (int size : cycles.keySet()) {
            int temp = 0;
            ArrayList<ArrayList<Integer>> hSet = cycles.get(size);
            if (size > w) {
                temp = (int) ((Math.ceil(size * 1.0 / (w - 1))) - 1);
                num += temp * hSet.size();
                for (int i = 0; i < hSet.size(); i++) {
                    ArrayList<Integer> aList = hSet.get(i);

                }
            } else if (size >= w - 1) {
                num += hSet.size();

            } else { // optimize!

            }
        }
        System.out.println(num);
        System.out.println(ans.toString());
    }
    public static void recurs (int group, boolean[] vis2, ArrayList<Integer> index) {
        if (vis2[group]) {
            if (cycles.containsKey(index.size())) cycles.get(index.size()).add(index);
            else {
                ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
                aList.add(index);
                cycles.put(index.size(), aList);
            }
            return;
        }
        vis2[group] = true;
        int cur = next[group]++;
        index.add(cur);
        vis2[group] = true;
        recurs(input[cur], vis2, index);
    }
}
