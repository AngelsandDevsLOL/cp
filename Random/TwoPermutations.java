package Random;

import java.util.HashMap;
import java.util.Scanner;

public class TwoPermutations {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> hMap1 = new HashMap<>();
        HashMap<Integer, Integer> hMap2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + i);
            System.out.flush();
            int x = sc.nextInt(), y = sc.nextInt();
            if (x == y) break;
            if (hMap2.containsKey(x)) {
                System.out.println(i + " " + hMap2.get(x));
                System.out.flush();
                break;
            } else {
                hMap2.put(y, i);
            }
            if (hMap1.containsKey(y)) {
                System.out.println(hMap2.get(y) + " " + i);
                System.out.flush();
                break;
            } else {
                hMap1.put(x, i);
            }
        }
    }
}
