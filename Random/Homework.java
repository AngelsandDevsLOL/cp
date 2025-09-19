package Random;

import java.util.*;

public class Homework {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] primavity = new int[10000001];
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
        for (int i = 2; i <= primavity.length/2+1; i++) {
            if (primavity[i] != 0) continue;
            for (int j = i; j < primavity.length; j = j + i) {
                primavity[j]++;
            }
        }
        for (int i = 2; i < primavity.length; i++) {
            if (hMap.containsKey(primavity[i])) {
                hMap.get(primavity[i]).add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(i);
                hMap.put(primavity[i], aList);
            }
        }
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");
            if (hMap.get(k) != null) {
                ArrayList<Integer> aList = hMap.get(k);
                int x = Collections.binarySearch(aList,a);
                int y = Collections.binarySearch(aList, b);
                if (x < 0) {
                    x = (-x -1);
                }
                if (y < 0) {
                    y = (-y -2);
                }
                System.out.println(y - x+1);
            } else System.out.println(0);
        }
    }
}
