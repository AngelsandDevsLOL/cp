package CCO;

import java.util.Arrays;
import java.util.Scanner;

public class TheMonkeyDance {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x != 0) {
            int[] parent = new int[x];
            Arrays.fill(parent, -1);
            for (int i = 0; i < x; i++) {
                int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
                int parentb = parent(b, parent);
                int parenta = parent(a, parent);
                if (parentb != parenta) {
                    parent[parenta] += parent[parentb];
                    parent[parentb] = parenta;
                }
            }
            int gcd = 0;
            for (int i = 0; i < x; i++) {
                if (parent[i] < 0) {
                    if (gcd == 0) gcd = -parent[i];
                    else gcd = gcd(gcd, -parent[i]);
                }
            }
            int lcm = gcd;
            for (int i = 0; i < x; i++) {
                if (parent[i] < 0) lcm *= (-parent[i] / gcd);
            }
            System.out.println(lcm);
            x = sc.nextInt();
        }
    }
    public static int parent (int x, int[] parent) {
        if (parent[x] < 0) {
            return x;
        }
        parent[x] = parent(parent[x], parent);
        return parent[x];
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
