package LCC;

import java.util.HashMap;
import java.util.Scanner;

public class BettingOdds {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt();
        HashMap<Integer, Integer> hMap = new HashMap();
        for (int i = 0; i < n; i++) {
            hMap.put(sc.nextInt(), i);
        }
        for (int i = 0; i < p; i++) {
            int input = sc.nextInt();
            if (hMap.containsKey(input)) System.out.println(hMap.get(input));
            else System.out.println(-1);
        }
    }
}
