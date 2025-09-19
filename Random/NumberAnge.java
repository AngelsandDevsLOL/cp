package Random;

import java.util.Scanner;

public class NumberAnge {
    static long r;
    static long count = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextLong();
        int d = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < d; j++) {
                sb.append(i);
            }
            recursion(sb.toString());
        }
        System.out.println(count);
    }
    public static void recursion (String val) {
        if (Long.parseLong(val) > r) return;
        if (val.length() == String.valueOf(r).length()) {
            count++; return;
        }
        count++;
        recursion(val + "0");
        for (int i = 1; i <= 9; i++) {
            recursion(val + (i));
            recursion((i) + val);
        }
    }
}
