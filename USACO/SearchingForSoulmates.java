package USACO;

import java.util.*;
public class SearchingForSoulmates {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int count = 0;
            while (x != y) {
                if (x < y) {
                    if (x * 2 == y || x * 2 == y-1) {
                        count++;
                        x = x * 2;
                    } else {
                        count++;
                        x++;
                    }
                } else {
                    if (x % 2 == 0) {
                        x = x / 2;
                        count++;
                    } else {
                        x++;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}