package CCC.Junior;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GoodGroups {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        HashMap<String, HashSet<String>> same = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            String[] names = scanner.nextLine().split(" ");
            if (same.containsKey(names[0])) {
                same.get(names[0]).add(names[1]);
            } else {
                HashSet<String> aList = new HashSet();
                aList.add(names[1]);
                same.put(names[0], aList);
            }
            if (same.containsKey(names[1])) {
                same.get(names[1]).add(names[0]);
            } else {
                HashSet<String> aList = new HashSet();
                aList.add(names[0]);
                same.put(names[1], aList);
            }
        }
        int y = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, HashSet<String>> dif = new HashMap<>();
        for (int i = 0; i < y; i++) {
            String[] names = scanner.nextLine().split(" ");
            if (dif.containsKey(names[0])) {
                dif.get(names[0]).add(names[1]);
            } else {
                HashSet<String> aList = new HashSet();
                aList.add(names[1]);
                dif.put(names[0], aList);
            }
            if (dif.containsKey(names[1])) {
                dif.get(names[1]).add(names[0]);
            } else {
                HashSet<String> aList = new HashSet();
                aList.add(names[0]);
                dif.put(names[1], aList);
            }
        }
        int count = 0;
        int g = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < g; i++) {
            String[] names = scanner.nextLine().split(" "); // group of 3 people
            for (int j = 0; j < 3; j++) {
                HashSet<String> hSet = same.get(names[j]);
                if (hSet != null) {
                    for (String name : hSet) {
                        boolean bool = false;
                        for (int k = 0; k < 3; k++) {
                            if (names[k].equals(name)) {
                                bool = true;
                            }
                        }
                        if (!bool) count++;
                        same.get(name).remove(names[j]);
                    }
                }
                hSet = dif.get(names[j]);
                for (int k = 0; k < 3 && hSet != null; k++) {
                    if (hSet.contains(names[k])) {
                        count++;
                        dif.get(names[k]).remove(names[j]);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
