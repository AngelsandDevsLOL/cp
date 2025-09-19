package COCI;

import java.util.Scanner;
import java.util.TreeMap;

public class Turnir {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = (int) Math.pow(2, y);
        int[] ar = new int[x];
        int largest = 0;
        TreeMap<Integer, Integer> counting = new TreeMap<>(); // value, amount
        for (int i = 0; i < x; i++) {
            int input = scanner.nextInt();
            ar[i] = input;
            if (counting.containsKey(input)) {
                counting.replace(input,counting.get(input)+1);
            } else {
                counting.put(input, 1);
            }
            if (input > largest) {
                largest = input;
            }
        }
        long[] array = new long[largest + 1];
        int largestt = 0;
        for (int i : counting.keySet()) {
            largestt = largestt + counting.get(i) - 1;
            array[i - 1] = largestt;
            largestt++; // # of smaller numbers + duplicates - 1
        }
        int[] level = new int[y+1];
        level[0] = x - 1;
        for (int i = 1; i < y + 1; i++) {
            level[i] = (level[i-1] - 1) / 2;
        }
        for (int i = 0; i < ar.length; i++) {
            int num = ar[i]; // what nubmer next
            long anothernumber = array[num - 1]; // how many #s they're better than
            int rank = y + 1; // lowest rank
            for (int j = 0; j < level.length; j++) {
                if (anothernumber >= level[j]) {
                    rank = j;
                    break;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
