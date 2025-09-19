package Algorithms;

import java.util.*;
import java.io.*;

public class SegTree {
    public static int[] ar;
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int height = (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
        ar = new int[(int)Math.pow(2, height)];
        Arrays.fill(ar, Integer.MAX_VALUE);
        int[] input = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            input[i] = sc.nextInt();
        }
        sc.nextLine();
        build(1, n, 1, input);
        for (int i = 0; i < m; i++) {
            String[] in = sc.nextLine().split(" ");
            if (in[0].equals("Q")) {
                System.out.println(query(1, n, Integer.parseInt(in[1]) + 1, Integer.parseInt(in[2]) + 1, 1));
            } else {
                update(1, n, Integer.parseInt(in[1]) + 1, 1, Integer.parseInt(in[2]));
            }
        }
    }
    public static int build (int l, int r, int ind, int[] input) {
        if (l == r) {ar[ind] = input[l]; return ar[ind];}
        int left = build(l, (l + r) / 2, ind * 2, input);
        int right = build((l + r) / 2 + 1, r, ind * 2 + 1, input);
        ar[ind] = Math.min(left, right);
        return ar[ind];
    }
    public static void update (int l, int r, int find, int ind, int update) {
        if (l != r) {
            int mid = (l + r) / 2;
            if (find > mid) { update(mid + 1, r , find, 2 * ind + 1, update); }
            else { update(l, mid, find, 2 * ind, update); }
            ar[ind] = Math.min(ar[ind * 2], ar[ind * 2 + 1]);
        } else { ar[ind] = update; }
    }
    public static int query (int l, int r, int ll, int rr, int ind) {
        if (l == ll && r == rr) return ar[ind];
        if (l == r) return ar[ind];
        if (rr <= (l + r) / 2) {
            return query(l, (l + r) / 2, ll, rr, ind * 2);
        } else if (ll >= (l + r) / 2 + 1) {
            return query((l + r) / 2 + 1, r, ll, rr, ind * 2 + 1);
        }
        return Math.min(query(l, (l + r) / 2, ll, (l + r) / 2, ind * 2), query((l + r) / 2 + 1, r, (l + r) / 2 + 1, rr, ind * 2 + 1));
    }
}
