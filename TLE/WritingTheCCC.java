package TLE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WritingTheCCC {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[t];
        HashMap<String, ArrayList<Integer>> hMap = new HashMap<>();
        for (int i = 0; i < t; i++) {
            array[i] = scanner.nextLine();
        }
        int n = scanner.nextInt();
        String[] array2 = new String[n];
        // store the first t letters - must be like an order
        // store the next n letters - must be able to contain duplicates - not a hashmap -
        // go find the first string, find the order, print. Do the next for the next n
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            array2[i] = input;
            if (hMap.containsKey(input)) {
                hMap.get(input).add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                hMap.put(input, aList);
            }
        }
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> aList = hMap.get(array[i]);
              if (aList!=null) {
                for (int j = 0; j < aList.size(); j++) {
                    System.out.println(aList.get(j) + 1);
                }
              }
        }
    }
}
