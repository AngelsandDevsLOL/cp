package Random;

import java.util.Scanner;

public class AllOutWar {
    public static int[] orig;
    public static int[] segTree;
    public static int[] lazy;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        orig = new int[n + 1];
        segTree = new int[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1)];
        lazy = new int[segTree.length];
        for (int i = 1; i <= n; i++) {
            int r = sc.nextInt();
            orig[i] = r;
        }
        build(1, n, 1);
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int x = update(1, n, a, b, 1, c);
            if (lazy[1] != 0) push(1, n, 1);
            System.out.println(x + " " + segTree[1]);
        }
    }
    public static void build (int l, int r, int ind) {
        if (l == r) {
            segTree[ind] = orig[l];
            return;
        }
        int mid = (l + r) / 2;
        build(l, mid, ind * 2);
        build(mid + 1, r, ind * 2 + 1);
        segTree[ind] = Math.min(segTree[ind * 2], segTree[ind * 2 + 1]);
    }
    public static int update (int l, int r, int ll, int rr, int ind, int val) {
        if (l == ll && r == rr) {
            segTree[ind] -= val;
            segTree[ind] = Math.max(segTree[ind], 0);
            if (lazy[ind] != 0) push(l, r, ind);
            return segTree[ind];
        }
        int mid = (l + r) / 2;
        int ans = 0;
        if (rr <= mid) {
            ans = update(l, mid, ll, rr, ind * 2, val);
        } else if (ll > mid) {
            ans = update(mid + 1, r, ll, rr, ind * 2 + 1, val);
        } else {
            ans = Math.min(update(l, mid, ll, mid, ind * 2, val), update(mid + 1, r, mid + 1, rr, ind * 2 + 1, val));
        }
        segTree[ind] = Math.min(segTree[ind * 2], segTree[ind * 2 + 1]);
        return ans;
    }
    public static void push (int l, int r, int ind) {
        int mid = (l + r) / 2;
        segTree[ind * 2] -= lazy[ind] * (mid - l + 1);
        segTree[ind * 2] = Math.max(segTree[ind * 2], 0);
        lazy[ind * 2] += lazy[ind] * (mid - 1 + 1);
        segTree[ind * 2 + 1] -= lazy[ind] * (r - mid + 1);
        segTree[ind * 2 + 1] = Math.max(segTree[ind * 2 + 1], 0);
        lazy[ind * 2 + 1] += lazy[ind] * (r - mid + 1);
        lazy[ind] = 0;
    }
}
