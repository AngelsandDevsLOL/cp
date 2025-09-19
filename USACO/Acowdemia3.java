package USACO;

import java.util.ArrayList;
import java.util.Scanner;

public class Acowdemia3 {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int pairs = 0;
        ArrayList<String> aList = new ArrayList();
        scanner.nextLine();
        String[][] array = new String[n][m];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = input.substring(j,j+1);
                if (input.substring(j,j+1).equals("G")){
                    aList.add(i + " " + j);
                }
            }
        }
        for (int i = 0; i < aList.size(); i++) {
            int count = 0;
            String[] arrayy = aList.get(i).split(" ");
            int x = Integer.parseInt(arrayy[0]);
            int y = Integer.parseInt(arrayy[1]);
            if (x > 0 && array[x-1][y].equals("C")){
                count++;
            } if (x < m && array[x+1][y].equals("C")){
                count++;
            } if (y > 0 && array[x][y-1].equals("C")){
                count++;
            } if (y < m && array[x][y+1].equals("C")){
                count++;
            }
            if (count >= 2){
                pairs++;
            }
        }
        System.out.println(pairs);
    }
}
