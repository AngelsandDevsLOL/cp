package CCC;

import java.util.*;

public class PowerRanking {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int[] array = new int[n];
        String[] string = new String[n];
        TreeMap<Integer, String> tMap = new TreeMap<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            string[i] = scanner.nextLine();
        }
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                array[j] = array[j] + scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            tMap.put(array[i],string[i]);
        }
        ArrayList<String> newList = new ArrayList<>(tMap.values());
        int num = 3;
        for (int i = n; i > 0; i--) {
            System.out.println(num + ". " + newList.get(i-1));
            num++;
        }
    }
}
