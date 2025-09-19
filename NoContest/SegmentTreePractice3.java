package NoContest;

import java.util.Scanner;

public class SegmentTreePractice3 {
    public static long[] seg;
    public static int[] orig;
    public static long[] sumTree;
    public static void main (String[] arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        seg = new long[(int)Math.pow(2, (int)Math.ceil(Math.log(n) / Math.log(2)) + 1)];
        sumTree = new long[seg.length];
        orig = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            orig[i] = a;
        }
        build(1, n, 1);

    }
    public static void build (int l, int r,int ind) {
        if (l == r) {
            sumTree[ind] = orig[l];
            seg[ind] = orig[l];
        }
        int mid = (l + r) / 2;
        build(l, mid, ind * 2);
        build(mid + 1, r, ind * 2 + 1);
        sumTree[ind] = sumTree[ind * 2] + sumTree[ind* 2 + 1];
        seg[ind] = Math.max(seg[ind * 2], sumTree[ind * 2] + seg[ind * 2 + 1]);
    }
    public static void update (int l, int r, int find, int ind, int val) {
        if (l == r) {
            seg[ind] = val;
            sumTree[ind] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (find <= mid) update(l, mid, find, ind * 2, val);
        else update(mid + 1, r, find, ind * 2 + 1, val);
        sumTree[ind] = sumTree[ind * 2] + sumTree[ind* 2 + 1];
        seg[ind] = Math.max(seg[ind * 2], sumTree[ind * 2] + seg[ind * 2 + 1]);
    }
    public static long query (int l, int r, int ll, int rr, int ind) {
        if (l == r) return seg[ind];
        int mid = (l + r) / 2;
        if (ll > mid) {
            return query(mid + 1, r, ll, rr, ind * 2+  1);
        } else if (rr < mid) {
            return query(l, mid, ll, rr, ind * 2);
        }
        return query(l, mid, ll, mid, ind); // w/ mid + 1, r, mid, rr, ind * 2 + !;
    }
}
