package AnimalContest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SquirrelStructures {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, HashSet<Integer>> hMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            HashSet<Integer> hSet = new HashSet<Integer>();
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    hSet.add(j);
                }
            }
            hMap.put(i, hSet);
        }
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (hMap.containsKey(x)) {
                if (hMap.get(x).contains(y)) {
                    hMap.get(x).remove(y);
                    if (hMap.get(x).isEmpty()) {
                        hMap.remove(x);
                    }
                }
            }
        }
    }
}
