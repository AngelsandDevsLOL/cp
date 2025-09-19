package USACO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Blocks {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, ArrayList<Integer>> hMap = new HashMap<>();
        HashMap<Integer, ArrayList<String>> hMap2 = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine();
            ArrayList<String> aList1 = new ArrayList<>();
            for (int j = 0; j < input.length(); j++) {
                if (hMap.containsKey(input.substring(j,j+1))) {
                    ArrayList<Integer> aList = hMap.get(input.substring(j,j+1));
                    if (!aList.contains(j)) {
                        hMap.get(input.substring(j,j+1)).add(j);
                    }
                } else {
                    ArrayList<Integer> aList = new ArrayList<>();
                    aList.add(j);
                    hMap.put(input.substring(j,j+1), aList);
                }
                if (!aList1.contains(input.substring(j,j+1))) {
                    aList1.add(input.substring(j,j+1));
                }
            }
            hMap2.put(i, aList1);
        }
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            int length = input.length();
            if (length == 1) {
                ArrayList<Integer> aList = hMap.get(input.substring(0,1));
                if (aList != null) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (length == 2) {
                ArrayList<Integer> aList = hMap.get(input.substring(1,2));
                ArrayList<Integer> aList2 = hMap.get(input.substring(0,1));
                if (aList == null || aList2 == null) {
                    System.out.println("NO");
                    break;
                }
                for (int integer : aList) {
                    if (!aList2.contains(integer)) {
                        System.out.println("YES");
                    }
                }
            } else if (length == 3) {
                ArrayList<Integer> aList = hMap.get(input.substring(0,1));
                ArrayList<Integer> aList2 = hMap.get(input.substring(1,2));
                ArrayList<Integer> aList3 = hMap.get(input.substring(2,3));
                if (aList == null || aList2 == null || aList3 == null) {
                    System.out.println("NO");
                    break;
                }
                boolean bool = false;
                for (int j = 0; j < aList.size(); j++) {
                    int num1 = aList.get(j);
                    for (int k = 0; k < aList2.size(); k++) {
                        int num2 = aList2.get(k);
                        for (int l = 0; l < aList3.size(); l++) {
                            int num3 = aList3.get(l);
                            if (num1 != num2 && num2 != num3 && num3 != num1) {
                                System.out.println("YES");
                                bool = true;
                                break;
                            }
                        }
                    }
                }
                if (!bool) {
                    System.out.println("NO");
                }
            } else if (length == 4) {
                HashSet<Integer> hSet = new HashSet<>();
                ArrayList<String> aList = hMap2.get(0);
                ArrayList<String> aList2 = hMap2.get(1);
                ArrayList<String> aList3 = hMap2.get(2);
                ArrayList<String> aList4 = hMap2.get(3);
                boolean bool = false;
                for (int j = 0; j < 4; j++) {
                    if (aList.contains(input.substring(j,j+1))) {
                        hSet.add(j);
                        for (int k = 0; k < 4; k++) {
                            if (k != j && aList2.contains(input.substring(k,k+1))) {
                                hSet.add(k);
                                for (int l = 0; l < 4; l++) {
                                    if (l != k && l != j && aList3.contains(input.substring(l,l+1))) {
                                        hSet.add(l);
                                        if (hSet.contains(0) && aList4.contains(input.substring(0,1))) {
                                            bool = true;
                                            break;
                                        } else if (hSet.contains(1) && aList4.contains(input.substring(1,2))) {
                                            bool = true;
                                            break;
                                        } else if (hSet.contains(2) && aList4.contains(input.substring(2,3))) {
                                            bool = true;
                                            break;
                                        } else if (hSet.contains(3) && aList4.contains(input.substring(3,4))) {
                                            bool = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (bool) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
