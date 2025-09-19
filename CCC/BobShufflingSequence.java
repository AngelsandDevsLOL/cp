package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class BobShufflingSequence {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int count = 0;
        int middle = n/2;
        int[] newa = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        newa[0] = array[middle];
        int a = 0;
        if (newa[0] - array[0] > array[n-1] - newa[0]){
            for (int i = 1; i < n; i = i + 2) {
                newa[i] = array[a];
                a++;
            }
            for (int i = 2; i < n; i = i + 2) {
                newa[newa.length-i+1] = array[n-a];
                a++;
            }
        } else {
            for (int i = 1; i < n; i = i + 2) {
                newa[i] = array[n-a-1];
                a++;
            }
            a = 0;
            for (int i = 2; i < n; i = i + 2) {
                newa[i] = array[a];
                a++;
            }
        }
        for (int i = 0; i < n-1; i++) {
            count = count + Math.abs(newa[i] - newa[i+1]);
        }
        System.out.println(count);
    }
}
