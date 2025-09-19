package CCO;

import java.util.Scanner;
import java.util.TreeMap;

public class AlienInvasion {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            int count = 0;
            for (int j = 0; j < num; j++) {
                int input = sc.nextInt();
                if (tMap.ceilingKey(input) != null) {
                    int x = tMap.ceilingKey(input);
                    if (tMap.get(x) == 1) {
                        tMap.remove(x);
                    } else {
                        tMap.put(x, tMap.get(x) - 1);
                    }
                    if (tMap.containsKey(input)) {
                        tMap.put(input, tMap.get(input) + 1);
                    } else {
                        tMap.put(input, 1);
                    }
                } else {
                    count++;
                    if (tMap.containsKey(input)) {
                        tMap.put(input, tMap.get(input) + 1);
                    } else {
                        tMap.put(input, 1);
                    }
                }
            }
            System.out.println(count);
        }
    }
}
