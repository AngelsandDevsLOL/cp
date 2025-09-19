package Random;

import java.io.*;
import java.util.*;

public class Main {
    static int c = 0;
    static int length;
    static int m;
    static String string = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        length = n;
        m = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = String.valueOf(input.substring(i, i+1));
        }
        recursion(input.substring(0,1), 1, array);
        System.out.println(c);
    }
    static void recursion (String input, int num, String[] array) { // string to add or not to add
        if (num == length) {
            String[] ar = input.split(" ");
            int count = 0;
            for (int i = 0; i < ar.length; i++) {
                String string = ar[i];
                count = count + Integer.parseInt(string);
            }
            if (count >= m) {
                return;
            }
            if (string.contains(" " + count + " ")) {
                return;
            } else {
                string = string + " " + count + " ";
                c++;
                return;
            }
        } else {
            recursion (input + " " + array[num], num + 1, array);
            recursion (input + array[num], num + 1, array);
        }
    }
}