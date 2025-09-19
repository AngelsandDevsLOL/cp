package CCC;

import java.util.HashMap;
import java.util.Scanner;

public class Stargazing {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][2];
        int[][] array2 = new int[n][3];
        for (int i = 0; i < n-1; i++) {
            array2[i][0] = scanner.nextInt();
            array2[i][1] = scanner.nextInt();
            array2[i][2] = scanner.nextInt();
        }
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("0 0", 0);
        for (int i = 0; i < n-1; i++) {
            int p = array2[i][0];
            int x = array2[i][1];
            int y = array2[i][2];
            array[i+1][0] = array[p-1][0] + x;
            array[i+1][1] = array[p-1][1] + y;
            hMap.put(array[i+1][0] + " " + array[i+1][1],0);
        }
        System.out.println(hMap.size());
    }
}
