package DMOPC;

import java.io.*;
import java.util.*;

public class BoardNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long min = 1;
        long max = (long) 1e12;
        long prev = 0;
        for (int i = 1; i < n; i++) {
            long s = scanner.nextLong();
            prev = s - prev;
            if (i % 2 != 0) {
                max = Math.min(max, prev - 1);
            } else {
                min = Math.max(min, -prev + 1);
            }
        }
        System.out.println(Math.max(0, max - min + 1));
    }
}