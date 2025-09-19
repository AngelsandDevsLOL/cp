package MALD;

import java.util.Scanner;
import java.util.TreeSet;

public class ScratchCatandDDoS {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        TreeSet<String> tSet = new TreeSet<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            array[i] = input;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("yubo")) {
                if (i != 0) {
                    tSet.add(array[i - 1]);
                } if (i != n - 1) {
                    tSet.add(array[i + 1]);
                }
                tSet.add(array[i]);
            }
        }
        for (String i: tSet) {
            System.out.println(i);
        }
    }
}
