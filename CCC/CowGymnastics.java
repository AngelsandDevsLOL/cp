package CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class CowGymnastics {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] array = new int[k][n];
        // get all the pairs
        // if future pairs flipped are on the list - delete
        ArrayList<String> aList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                 array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int a = j+1; a < n; a++) {
                    String string = String.valueOf(array[i][j]) + "," + String.valueOf(array[i][a]);
                    String string2 = String.valueOf(array[i][a]) + "," + String.valueOf(array[i][j]);
                    if (aList.contains(string2)) {
                        aList.remove(string2);
                    } else if (!(string.equals(string2)) && !aList.contains(string) && i == 0) {
                        aList.add(string);
                    }
                }
            }
        }
        System.out.println(aList.size());
    }
}