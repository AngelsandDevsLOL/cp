package AtCOder;

import java.util.HashMap;
import java.util.Scanner;

public class SquarePermutation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long in = sc.nextLong();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = (int) (in % 10);
            in /= 10;
            if (hMap.containsKey(x)) hMap.put(x, hMap.get(x) + 1);
            else hMap.put(x, 1);
        }
        long count = 0;
        System.out.println((int) Math.sqrt(Math.pow(10, hMap.get(0))));
        System.out.println(Math.sqrt(in) + 1);
        for (int i = (int) Math.sqrt(Math.pow(10, hMap.get(0))); i <= Math.sqrt(in) + 1; i++) {
            long x = (long) i * i;
            int tempN = String.valueOf(x).length();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < tempN; j++) {
                int y = (int) (x % 10);
                x /= 10;
                if (hMap.containsKey(y)) hMap.put(y, hMap.get(y) + 1);
                else hMap.put(y, 1);
            }
            if (map.equals(hMap)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
