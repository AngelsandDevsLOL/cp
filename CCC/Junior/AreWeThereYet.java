package CCC.Junior;

import java.util.Scanner;

public class AreWeThereYet {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[4];
        for (int i = 0; i < 4; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                int count = 0;
                int greater = i;
                int smaller = i;
                if (i > j) {
                    greater = i;
                    smaller = j;
                } else {
                    greater = j;
                    smaller = i;
                }
                for (int k = smaller; k < greater; k++) {
                    count = count + array[k];
                }
                System.out.print(count + " ");
            }
            System.out.println();
        }
    }
}
