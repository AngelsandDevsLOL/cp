package USACO;


import java.util.Scanner;

public class AirCownditioningII {
    public static int scost = (int) 1e9;
    public static int n, m;
    public static int[][] ac;
    public static int[] needed;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        needed = new int[101];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(), t = sc.nextInt(), c = sc.nextInt();
            needed[s] += c;
            needed[t + 1] -= c;
        }
        for (int i = 1; i < 101; i++) {
            needed[i] += needed[i-1];
        }
        ac = new int[m][4];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt(), m = sc.nextInt();
            ac[i][0] = a; ac[i][1] = b; ac[i][2] = p; ac[i][3] = m;
        }
        generate("", 0);
        System.out.println(scost);
    }
    public static void check (String s, int x) {
        int[] psa = new int[101];
        if (s.equals("")) return;
        String[] a = s.substring(1).split(" ");
        int cost = 0;
        for (int i = 0; i < a.length; i++) {
            cost += ac[Integer.parseInt(a[i])][3];
            psa[ac[Integer.parseInt(a[i])][0]] += ac[Integer.parseInt(a[i])][2];
            psa[ac[Integer.parseInt(a[i])][1] + 1] -= ac[Integer.parseInt(a[i])][2];
        }
        for (int i = 1; i < 101; i++) {
            psa[i] += psa[i-1];
        }
        boolean bool = true;
        for (int i = 0; i < needed.length; i++) {
            if (needed[i] > psa[i]) {
                bool = false;
                break;
            }
        }
        if (bool) {
            scost = Math.min(scost, cost);
        }
    }
    public static void generate (String s, int x) {
        if (x == m) {
            check(s, x); return;
        }
        generate(s, x + 1);
        generate(s + " "+ x, x + 1);
    }
}
