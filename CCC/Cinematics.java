package CCC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Cinematics {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int y = scanner.nextInt();
        long sum = 0;
        scanner.nextLine();
        String[][] array = new String[n][2];
        HashMap<String, Integer> hMap = new HashMap();
        HashMap<String, Integer> hMap2 = new HashMap();
        HashSet<String> watched = new HashSet();
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            array[i][1] = String.valueOf(scanner.nextInt());
            hMap.put(array[i][0], Integer.parseInt(array[i][1]));
        }
        scanner.nextLine();
        for (int i = 0; i < y; i++) {
            String input = scanner.nextLine();
            if (watched.contains(input)) {
                continue;
            } else {
                watched.add(input);
                sum = sum + hMap.get(input);
            }
        }
        System.out.println(sum);
    }
}
