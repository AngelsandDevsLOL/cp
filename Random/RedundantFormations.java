package Random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RedundantFormations {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<String, Integer> hMap = new HashMap<>();
        HashSet<String> done = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 2; j <= input.length(); j++) {
                String str = input.substring(i, j);
                if (hMap.containsKey(str) && i - hMap.get(str) - (j - i) < 0) {
                    done.add(str);
                } else {
                    hMap.put(str, i);
                }
            }
        }
        System.out.println(done.size());
    }
}
