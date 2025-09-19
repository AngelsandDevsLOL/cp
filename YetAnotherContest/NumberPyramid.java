package YetAnotherContest;

import java.io.*;
import java.util.*;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        for (int i = n-1; i > 0; i--) {
            double v = Math.pow(2, i - 1) * (k - 1) % k;
            if (v <= x) {
                x = (int) (x - v);
            } else {
                x = (int) (x - v + k);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == n-1) System.out.println(x);
            else {
                System.out.print((k - 1) + " ");
            }
        }
    }
}