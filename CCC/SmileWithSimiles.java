package CCC;

import java.util.Scanner;

public class SmileWithSimiles {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] array = new String[n];
        String[] array1 = new String[m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLine();
        }
        for (int i = 0; i < m; i++) {
            array1[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(array[i] + " as " + array1[j]);
            }
        }
    }
}
