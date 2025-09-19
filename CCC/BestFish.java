package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class BestFish {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int[] cArray = new int[c];
        for (int i = 0; i < c; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            cArray[i] = x * y;
        }
        int n = scanner.nextInt();
        int[] nArray = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            nArray[i] = x * y;
        }
        Arrays.sort(cArray);
        Arrays.sort(nArray);
        if (cArray[cArray.length-1] > nArray[nArray.length-1]){
            System.out.println("Casper");
        } else if (cArray[cArray.length-1] < nArray[nArray.length-1]){
            System.out.println("Natalie");
        } else
            System.out.println("Tie");
    }
}
