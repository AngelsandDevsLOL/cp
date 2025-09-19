package Random;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class BobandBusStops {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] array = new long[n];
        TreeMap<Long, Long> tMap = new TreeMap();
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            tMap.put(array[i], (long) i);
        }
        for (int i = 0; i < q; i++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            Object num1 = tMap.ceilingKey(l);
            if (num1 != null) {
                long num2 = tMap.floorKey(r);
                System.out.println(tMap.get(num2)-tMap.get(num1) + 1);
            } else {
                System.out.println(0);
            }
        } // treemap (n, index) - treemap search ceil and floor get index subtract
    }
}
