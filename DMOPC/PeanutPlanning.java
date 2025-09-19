package DMOPC;

import java.util.Arrays;
import java.util.Scanner;

public class PeanutPlanning {
    static int[] parent;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        int[] shops = new int[n];
        for (int i = 0; i < n; i++) {
            shops[i] = scanner.nextInt();
        }
        Arrays.sort(shops);
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            if (n % 2 == 1 && i == n / 2) {
                ind = getParent(ind);
                sb.append(shops[ind]).append(" ");
            } else {
                ind = getParent(ind);
                if (ind == n) break;
                int index = binarySearch(ind + 1, n - 1, m - shops[ind], shops);
                if (index == -1) {
                    sb.delete(0, sb.toString().length());
                    sb.append("-1 ");
                    break;
                }
                parent[index] = index + 1;
                sb.append(shops[ind]).append(" ").append(shops[index]).append(" ");
                ind++;
            }
        }
        System.out.println(sb.substring(0, sb.toString().length()-1));
    }
    public static int binarySearch (int low, int high, int find, int[] ar) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ar[mid] == find) {
                ans = mid;
                break;
            } else if (ar[mid] > find) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (ans == -1) return -1;
        int par = getParent(ans);
        if (par == ar.length) return -1;
        return par;
    }
    public static int getParent(int x) {
        if (parent[x] == -1) return x;
        else {
            parent[x] = getParent(parent[x]);
        }
        return parent[x];
    }
}
