package DMOPC;

import java.io.*;
import java.util.*;

public class EbolaOutbreak {
    public static int[] parent;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> aList = new ArrayList<>();
        parent = new int[n+1];
        Arrays.fill(parent, -1);
        for (int i = 0; i< m; i++) {
            int x  = scanner.nextInt();
            int[] ar = new int[x];
            for (int j = 0; j < x; j++) {
                ar[j] = scanner.nextInt();
            }
            Arrays.sort(ar);
            int p = find(ar[0]);
            for (int j = 1; j < x; j++) {
                int r = find(ar[j]);
                if (r != p) {
                    parent[p] = parent[p] + parent[r];
                    parent[r] = p;
                }
            }
        }
        int x = find(1);
        if (x < 0) {
            System.out.println(parent[1] * -1);
            System.out.print(1 + " ");
            for (int i = 2; i < n + 1; i++) {
                if (find(i) == 1) {
                    System.out.print(i + " ");
                }
            }
        } else {
            System.out.println(parent[x] * -1);
            System.out.print(1 + " ");
            for (int i = 2; i < n + 1; i++) {
                if (find(i) == x || i == parent[1]){
                    System.out.print(i + " ");
                }
            }
        }
    }
    public static int find(int x) {
        if (parent[x] > 0) {
            parent[x] = find(parent[x]);
        }
        if (parent[x] < 0) {
            return x;
        } else {
            return parent[x];
        }
    }
}