package CCC;

import java.util.Scanner;

public class LostInTheShuffle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] array = {0, 1, 2, 3, 4};
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            swap(array, a-1, b-1);
        }
        for (int i = 0; i < 5; i++) {
            if (array[i] == 2){
                System.out.println(i+1);
                break;
            }
        }
    }
    static void swap (int array[], int a, int b){
        final int x = array[a];
        array[a] = array[b];
        array[b] = x;
    }
}