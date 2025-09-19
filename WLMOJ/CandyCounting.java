package WLMOJ;

import java.util.HashMap;
import java.util.Scanner;

public class CandyCounting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            if (hMap.containsKey(input)) {
                hMap.put(input, hMap.get(input) + 1);
            } else {
                hMap.put(input, 1);
            }
        }
        int count = 0;
        for (String in : hMap.keySet()) {
            count += hMap.get(in) % m;
        }
        System.out.println(count);
    }
}
