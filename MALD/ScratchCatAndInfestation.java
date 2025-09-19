package MALD;

import java.util.Arrays;
import java.util.Scanner;

public class ScratchCatAndInfestation {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        int cat = 0;
        int infectedCats = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int day = 0;
        while (infectedCats < n) {
            day++;
            infectedCats = infectedCats + (infectedCats / k);
            while (cat < n && array[cat] == day) {
                infectedCats++;
                cat++;
            }
        }
        System.out.println(day);
    }
}
