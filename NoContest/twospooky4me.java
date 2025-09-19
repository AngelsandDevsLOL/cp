package NoContest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class twospooky4me {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), l = sc.nextInt(), s = sc.nextInt();
        TreeSet<Integer> index = new TreeSet<>();
        int[][] ar = new int[n][3];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            index.add(a); index.add(b + 1);
            ar[i][0] = a; ar[i][1] = b; ar[i][2] = c;
        }
        index.add(l);
        int[] arr = new int[index.size() + 1];
        int[] compressed = new int[index.size() + 1];
        HashMap<Integer, Integer> hMap = new HashMap<>();
        int counter = 1;
        for (int x : index) {
            hMap.put(x, counter);
            arr[counter] = x;
            counter++;
        }
        for (int i = 0; i < n; i++) {
            int x = hMap.get(ar[i][0]);
            int y = hMap.get(ar[i][1] + 1);
            compressed[x] += ar[i][2];
            compressed[y] -= ar[i][2];
        }
        int count = l;
        if (compressed[0] >= s) count++;
        for (int i = 1; i < compressed.length; i++) {
            compressed[i] += compressed[i - 1];
            if (compressed[i] >= s) {
                count -= arr[i + 1] - arr[i];
            }
        }
        System.out.println(count);
    }
}
