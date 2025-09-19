package DMOPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sorting {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int k = scanner.nextInt();
        long[] array = new long[Math.toIntExact(n)];
        for (long i = 0; i < n; i++) {
            array[Math.toIntExact(i)] = scanner.nextLong();
        }
        boolean bool = true;
        for (int i = 0; i < k; i++) {
            ArrayList<Long> aList = new ArrayList<>();
            for (int j = 0; j < n; j = j + k) {
                aList.add(array[j]);
            }
            Collections.sort(aList);
            for (int j = 0; j < aList.size(); j++) {
                if (!(aList.get(j) == ((j*k) + 1))) {
                    bool = false;
                }
            }
        }
        if (bool) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
