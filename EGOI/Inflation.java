package EGOI;

import java.util.Scanner;
import java.util.TreeMap;

public class Inflation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long inflation = 0;
        TreeMap<Long, Long> dishes = new TreeMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            if (dishes.containsKey(x)) dishes.put(x, dishes.get(x) + 1);
            else dishes.put(x, 1L);
            sum += x;
        }
        int q = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("INFLATION")) {
                inflation += Long.parseLong(input[1]);
                sum += (long) n * Long.parseLong(input[1]);
            } else {
                long x = Long.parseLong(input[1]) - inflation;
                long y = Long.parseLong(input[2]) - inflation;
                if (dishes.containsKey(x)) {
                    long temp = dishes.get(x);
                    dishes.remove(x);
                    sum += (temp * (y - x));

                    if (dishes.containsKey(y)) {
                        dishes.put(y, temp + dishes.get(y));
                    } else dishes.put(y, temp);

                }

            }
            System.out.println(sum);
        }
    }
}
