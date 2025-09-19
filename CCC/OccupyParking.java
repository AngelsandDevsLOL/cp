package CCC;

import java.util.Scanner;

public class OccupyParking {
    public static void main (String argv[] ){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] array = new boolean[n];
        scanner.nextLine();
        String input = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (input.substring(i,i+1).equals(".")){
                array[i] = false;
            } else if (input.substring(i,i+1).equals("C")) {
                array[i] = true;
            }
        }
        int count = 0;
        input = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            if (!array[i]) {
                continue;
            } else {
                if (input.substring(i,i+1).equals("C")) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
