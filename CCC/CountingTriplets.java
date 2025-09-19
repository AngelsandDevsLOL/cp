package CCC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CountingTriplets {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        HashSet<String> hSet = new HashSet();
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (array[i] + array[j] > array[k]){
                        break;
                    } else if (array[i] + array[j] == array[k] ) {
                        hSet.add(array[i] + " " + array[j]);
                        break;
                    }
                }
            }
        }
        if (hSet.isEmpty()){
            System.out.println(-1);
        } else
            System.out.println(hSet.size());
    }
}
