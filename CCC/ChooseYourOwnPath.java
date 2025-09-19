package CCC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ChooseYourOwnPath {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> endPages = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int m1 = scanner.nextInt();
            if (m1 == 0) {
                endPages.add(i);
            } else {
                ArrayList<Integer> aList = new ArrayList<>();
                for (int j = 0; j < m1; j++) {
                    aList.add(scanner.nextInt()-1);
                    hSet.add(aList.get(j));
                }
                hMap.put(i, aList);
            }
        }
        boolean bool = true;
        for (int i = 1; i < n; i++) {
            if (!hSet.contains(i)) {
                bool = false;
            }
        }
        if (bool) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        bool = true;
        int page = 0;
        int count = 0;
        ArrayList<Integer> aList = hMap.get(page);
    }
    static int recursion (int x, int y, int count, ArrayList<Integer> endPages, HashMap<Integer, ArrayList<Integer>> hMap, int page) {
        boolean bool = true;
        while (bool) {
            ArrayList<Integer> aList = hMap.get(page);
            for (int i = 0; i < endPages.size(); i++) {
                if (aList.contains(endPages.get(i))) {
                    bool = false;
                    count++;
                    return count;
                }
            }
            if (bool) {
                for (int i = 0; i < aList.size(); i++) {
                    aList.get(i);
                    recursion(x,y,count, endPages, hMap,page );
                }
                return x;
            }
        }
        return x;
    }
}
