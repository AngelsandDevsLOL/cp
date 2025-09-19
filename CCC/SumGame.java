package CCC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SumGame {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            array2[i] = scanner.nextInt();
        }
        ArrayList<Integer> aList = new ArrayList();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum1 + array[i];
            sum2 = sum2 + array2[i];
            if (sum1 == sum2){
                aList.add(i+1);
            }
        }
        Collections.sort(aList);
        if (aList.isEmpty()){
            System.out.println(0);
        } else
            System.out.println(aList.get(aList.size()-1));
    }
}
