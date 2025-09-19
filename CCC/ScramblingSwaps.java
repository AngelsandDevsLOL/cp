package CCC;

import java.util.LinkedList;
import java.util.Scanner;

public class ScramblingSwaps {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        LinkedList<int[]> ll = new LinkedList();
        for (int i = 0; i < q; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("B") || input[0].equals("E")){
                int[] array = {Integer.parseInt(input[1]), Integer.parseInt(input[2])};
                if (input[0].equals("E")) {
                    ll.addLast(array);
                } else
                    ll.addFirst(array);
            } else {
                int[] array = new int[n];
                for (int j = 0; j < n; j++) {
                    array[j] = Integer.parseInt(input[j + 1]);
                }
                int[] integer = new int[2];
                for (int k = ll.size()-1; k >= 0; k--) {
                    swap(ll.get(k)[0], ll.get(k)[1], array);
                }
                for (int k = 0; k < array.length; k++) {
                    if (k>0) {
                        System.out.print(" ");

                    }
                    System.out.print(array[k]);
                }
                System.out.println();
            }
        }
    }
    static void swap (int integer1, int integer2, int[] array){
        final int x = array[integer1-1];
        array[integer1-1] = array[integer2-1];
        array[integer2-1] = x;
    }
}
