package CCC;

import java.util.Scanner;

public class BobsHistogram {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int smallest = Integer.MAX_VALUE;
        int largest = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < smallest) {
                smallest = array[i];
            } else if (array[i] > largest){
                largest = array[i];
            }
        }
        int finalCount = Integer.MAX_VALUE;
        for (int i = smallest; i <= largest; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = (int) (count + Math.pow(array[j] - i,2));
            }
            if (count < finalCount){
                finalCount = count;
            }
        }
        System.out.println(finalCount);
    }
}
