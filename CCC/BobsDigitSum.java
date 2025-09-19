package CCC;

import java.util.Scanner;

public class BobsDigitSum {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] array = new int[x];
        String[] input = new String[x];
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            input[i] = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < input[i].length(); j++) {
                sum = sum + Integer.parseInt(input[i].substring(j,j+1));
            }
            array[i] = sum;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > sum){
                sum = array[i];
            }
        }
        System.out.println(sum);
    }
}
