package USACO;

import java.util.Scanner;

public class HungryCow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); long t = sc.nextLong();
        long curDay = 1;
        long eaten = 0;
        long haybales = 0;
        for (int i = 0; i < n; i++) {
            long d = sc.nextLong(), b = sc.nextLong();
            long daysBetween = d - curDay;
            eaten += Math.min(haybales, daysBetween);
            haybales = Math.max(haybales - daysBetween, 0);
            haybales += b;
            curDay = d;
        }
        long daysBetween = t - curDay + 1;
        eaten += Math.min(haybales, daysBetween);
        System.out.println(eaten);
    }
}
