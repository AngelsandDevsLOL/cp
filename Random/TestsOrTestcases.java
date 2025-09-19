package Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TestsOrTestcases {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        HashMap<Integer, ArrayList<String>> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            ArrayList<String> aList = new ArrayList<>();
            int number = Integer.parseInt(input[0]);
            for (int j = 1; j <= number; j++) {
                aList.add(input[j]);
            }
            hMap.put(i, aList);
        }
        for (int i = 0; i < l; i++) {

        }
    }
    static void recursion (HashMap<Integer, ArrayList<String>> hMap, int integer, int index, int l, String string) {
        if (string.length() != l) {
            ArrayList<String> aList = hMap.get(integer);
            if (aList.size() != index + 1) {
                string = string + aList.get(index);
                System.out.println(string);
            }
        }
    }
}
