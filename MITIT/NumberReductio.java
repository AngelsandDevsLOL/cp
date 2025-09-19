package MITIT;

import java.util.Scanner;
import java.util.TreeSet;

public class NumberReductio {
    public static TreeSet<Long> tSet = new TreeSet<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        recurs(1, n);
        System.out.println(tSet.size());
    }
    public static void recurs (long num, long n) {
        if (tSet.contains(num)) return;
        tSet.add(num);
        for (int i = 2; i <= 9; i++) {
            long newNum = num * i;
            if (newNum > n) return;
            if (String.valueOf(newNum).contains(String.valueOf(i))) {
                recurs(newNum, n);
            }
        }
    }
}
