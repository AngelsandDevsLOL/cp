package NoContest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class AnotherSorting {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, ArrayList> hMap = new HashMap<Integer, ArrayList>();
        ArrayList<Integer> array = new ArrayList();
        ArrayList<Integer> array1 = new ArrayList();
        ArrayList<Integer> array2 = new ArrayList();
        ArrayList<Integer> array3 = new ArrayList();
        ArrayList<Integer> array4 = new ArrayList();
        ArrayList<Integer> array5 = new ArrayList();
        ArrayList<Integer> array6 = new ArrayList();
        ArrayList<Integer> array7 = new ArrayList();
        ArrayList<Integer> array8 = new ArrayList();
        ArrayList<Integer> array9 = new ArrayList();
        hMap.put(0,array);
        hMap.put(1,array1);
        hMap.put(2,array2);
        hMap.put(3,array3);
        hMap.put(4,array4);
        hMap.put(5,array5);
        hMap.put(6,array6);
        hMap.put(7,array7);
        hMap.put(8,array8);
        hMap.put(9,array9);
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            String string = String.valueOf(input);
            int index = Integer.parseInt(string.substring(string.length()-1));
            hMap.get(index).add(input);
        }
        for (int i = 0; i <= 9; i++) {
            ArrayList<Integer> aList = hMap.get(i);
            if (!(aList.isEmpty())){
                Collections.sort(aList);
                for (int j = aList.size()-1; j >= 0; j--) {
                    System.out.print(aList.get(j) + " ");
                }
            }
        }
    }
}
