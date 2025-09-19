package CCC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SilentAuction2 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int largest = 0;
        HashMap<Integer, ArrayList<String>> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String name = scanner.nextLine();
            int number = scanner.nextInt();
            if (hMap.containsKey(number)) {
                hMap.get(number).add(name);
            } else {
                ArrayList<String> aList = new ArrayList<>();
                aList.add(name);
                hMap.put(number, aList);
            }
            if (number > largest) {
                largest = number;
            }
        }
        ArrayList<String> aList = hMap.get(largest);
        System.out.println(aList.get(0));
    }
}
