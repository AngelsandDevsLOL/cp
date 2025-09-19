package NoContest;

import java.util.Scanner;

public class BinaryIndexedTreeSet {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] ar = new int[n + 1];
        long[] bit1 = new long[n + 1];
        long[] bit2 = new long[100002];
        long[] bit3 = new long[100002];
        for (int i = 1; i <= n; i++) {
            int input = sc.nextInt();
            ar[i] = input;
            update(i, input, bit1);
            bit3[input]++;
        }
        for (int i = 1; i <= n; i++) {
            update(i, bit3[i], bit2);
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("C")) {
                int x = Integer.parseInt(input[1]);
                int v = Integer.parseInt(input[2]);
                if (ar[x] != v) {
                    update(ar[x], -1, bit2);
                    update(v, +1, bit2);
                    update(x, (v - ar[x]), bit1);
                }
            } else if (input[0].equals("S")) {
                System.out.println(sum(Integer.parseInt(input[2]), bit1) - sum(Integer.parseInt(input[1]) - 1, bit1));
            } else if (input[0].equals("Q")) {
                System.out.println(sum(Integer.parseInt(input[1]), bit2));
            }
        }
    }
    public static long sum (int x, long[] bit) {
        if (x == 0) return 0;
        int parent = x - ((~x + 1) & x);
        return bit[x] + sum(parent, bit);
    }
    public static int next (int x) {
        return x + ((~x + 1) & x);
    }
    public static void update(int index, long value, long[] bit) {
        if (index < bit.length) {
            bit[index] += value;
            update(next(index), value, bit);
        }
    }
}
