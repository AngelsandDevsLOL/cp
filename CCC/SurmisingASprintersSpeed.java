package CCC;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SurmisingASprintersSpeed {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] array = new int[n][2];
        double[] distance = new double[n-1];
        int[] difference = new int[n-1];
        for (int i = 0; i < n; i++) {
            int time = scanner.nextInt();
            int meters = scanner.nextInt();
            array[i][0] = time;
            array[i][1] = meters;
        }
        Sort2DArrayBasedOnColumnNumber(array,1);
        for (int i = 1; i < n; i++) {
            double time = array[i][0] - array[i-1][0];
            double x = array[i][1] - array[i-1][1];
            distance[i-1] = Math.abs(x/time);
        }
        Arrays.sort(distance);
        System.out.println(distance[distance.length-1]);
    }
    public static  void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                if(first[columnNumber-1] > second[columnNumber-1]) return 1;
                else return -1;
            }
        });
    }

}
