package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class ThatMissingNumber {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }
            Arrays.sort(array);
            int missing = n+1;
            for (int j = 0; j < n; j++) {
                if (array[j] != j+1){
                    missing = j+1;
                    break;
                }
            }
            System.out.println(missing);
        }
    }
}
