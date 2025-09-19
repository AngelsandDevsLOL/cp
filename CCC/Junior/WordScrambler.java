package CCC.Junior;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WordScrambler {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] array = new char[input.length()];
        HashMap <Integer, String> hMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i);
        }
        Arrays.sort(array);
        int length = array.length;
        for (int i = 0; i < length; i++) {
            hMap.put(i, String.valueOf(array[i]));
        }
        if (length == 1) {
            System.out.println(String.valueOf(array[0]));
        } else if (length == 2) {
            System.out.println(array[0] + String.valueOf(array[1]));
            System.out.println(array[1] + String.valueOf(array[0]));
        } else if (length == 3) {
            System.out.println(String.valueOf(array[0]) + array[1] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[1]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[0]);
            System.out.println(String.valueOf(array[2]) + array[0] + array[1]);
            System.out.println(String.valueOf(array[2]) + array[1] + array[0]);
        } else if (length == 4) {
            System.out.println(String.valueOf(array[0]) + array[1] + array[2] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[1] + array[3] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[1] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[3] + array[1]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[1] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[2] + array[1]);

            System.out.println(String.valueOf(array[1]) + array[0] + array[2] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[3] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[0] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[3] + array[0]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[0] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[2] + array[0]);

            System.out.println(String.valueOf(array[2]) + array[0] + array[1] + array[3]);
            System.out.println(String.valueOf(array[2]) + array[0] + array[3] + array[1]);
            System.out.println(String.valueOf(array[2]) + array[1] + array[2] + array[3]);
            System.out.println(String.valueOf(array[2]) + array[1] + array[3] + array[2]);
            System.out.println(String.valueOf(array[2]) + array[3] + array[0] + array[1]);
            System.out.println(String.valueOf(array[2]) + array[3] + array[1] + array[0]);

            System.out.println(String.valueOf(array[3]) + array[0] + array[1] + array[2]);
            System.out.println(String.valueOf(array[3]) + array[0] + array[2] + array[1]);
            System.out.println(String.valueOf(array[3]) + array[1] + array[0] + array[2]);
            System.out.println(String.valueOf(array[3]) + array[1] + array[2] + array[0]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[0] + array[1]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[1] + array[0]);

        } else if (length == 5) {
            final char x = array[0];
            final char z = array[2];
            final char ab = array[3];
            final char y = array[1];
            final char ac = array[4];
            array[4] = x;
            array[0] = y;
            array[1] = z;
            array[2] = ab;
            array[3] = ac;
            System.out.println(String.valueOf(array[4]) + array[0] + String.valueOf(array[1]) + array[2] + array[3]);
            System.out.println(String.valueOf(array[4]) + array[0] + String.valueOf(array[1]) + array[3] + array[2]);
            System.out.println(String.valueOf(array[4]) + array[0] + array[2] + String.valueOf(array[1]) + array[3]);
            System.out.println(String.valueOf(array[4]) + array[0] + array[2] + array[3] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[4]) + array[0] + array[3] + String.valueOf(array[1]) + array[2]);
            System.out.println(String.valueOf(array[4]) + array[0] + array[3] + array[2] + String.valueOf(array[1]));

            System.out.println(String.valueOf(array[4]) + String.valueOf(array[1]) + array[0] + array[2] + array[3]);
            System.out.println(String.valueOf(array[4]) + String.valueOf(array[1]) + array[0] + array[3] + array[2]);
            System.out.println(String.valueOf(array[4]) + String.valueOf(array[1]) + array[2] + array[0] + array[3]);
            System.out.println(String.valueOf(array[4]) + String.valueOf(array[1]) + array[2] + array[3] + array[0]);
            System.out.println(String.valueOf(array[4]) + String.valueOf(array[1]) + array[3] + array[0] + array[2]);
            System.out.println(String.valueOf(array[4]) + String.valueOf(array[1]) + array[3] + array[2] + array[0]);

            System.out.println(String.valueOf(array[4]) + array[2] + String.valueOf(array[1]) + array[0] + array[3]);
            System.out.println(String.valueOf(array[4]) + array[2] + String.valueOf(array[1]) + array[3] + array[0]);
            System.out.println(String.valueOf(array[4]) + array[2] + array[0] + String.valueOf(array[1]) + array[3]);
            System.out.println(String.valueOf(array[4]) + array[2] + array[0] + array[3] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[4]) + array[2] + array[3] + String.valueOf(array[1]) + array[0]);
            System.out.println(String.valueOf(array[4]) + array[2] + array[3] + array[0] + String.valueOf(array[1]));

            System.out.println(String.valueOf(array[4]) + array[3] + String.valueOf(array[1]) + array[2] + array[0]);
            System.out.println(String.valueOf(array[4]) + array[3] + String.valueOf(array[1]) + array[0] + array[2]);
            System.out.println(String.valueOf(array[4]) + array[3] + array[2] + String.valueOf(array[1]) + array[0]);
            System.out.println(String.valueOf(array[4]) + array[3] + array[2] + array[0] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[4]) + array[3] + array[0] + String.valueOf(array[1]) + array[2]);
            System.out.println(String.valueOf(array[4]) + array[3] + array[0] + array[2] + String.valueOf(array[1]));

            System.out.println(String.valueOf(array[0]) + array[4] + array[1] + array[2] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[4] + array[1] + array[3] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[4] + array[2] + array[1] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[4] + array[2] + array[3] + array[1]);
            System.out.println(String.valueOf(array[0]) + array[4] + array[3] + array[1] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[4] + array[3] + array[2] + array[1]);

            System.out.println(String.valueOf(array[0]) + array[1] + array[4] + array[2] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[1] + array[4] + array[3] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[1] + array[2] + array[4] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[1] + array[2] + array[3] + array[4]);
            System.out.println(String.valueOf(array[0]) + array[1] + array[3] + array[4] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[1] + array[3] + array[2] + array[4]);

            System.out.println(String.valueOf(array[0]) + array[2] + array[1] + array[4] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[1] + array[3] + array[4]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[4] + array[1] + array[3]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[4] + array[3] + array[1]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[3] + array[1] + array[4]);
            System.out.println(String.valueOf(array[0]) + array[2] + array[3] + array[4] + array[1]);

            System.out.println(String.valueOf(array[0]) + array[3] + array[1] + array[2] + array[4]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[1] + array[4] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[2] + array[1] + array[4]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[2] + array[4] + array[1]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[4] + array[1] + array[2]);
            System.out.println(String.valueOf(array[0]) + array[3] + array[4] + array[2] + array[1]);


            System.out.println(String.valueOf(array[1]) + array[4] + array[0] + array[2] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[4] + array[0] + array[3] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[4] + array[2] + array[0] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[4] + array[2] + array[3] + array[0]);
            System.out.println(String.valueOf(array[1]) + array[4] + array[3] + array[0] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[4] + array[3] + array[2] + array[0]);

            System.out.println(String.valueOf(array[1]) + array[0] + array[4] + array[2] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[4] + array[3] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[2] + array[4] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[2] + array[3] + array[4]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[3] + array[4] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[0] + array[3] + array[2] + array[4]);

            System.out.println(String.valueOf(array[1]) + array[2] + array[0] + array[4] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[0] + array[3] + array[4]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[4] + array[0] + array[3]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[4] + array[3] + array[0]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[3] + array[0] + array[4]);
            System.out.println(String.valueOf(array[1]) + array[2] + array[3] + array[4] + array[0]);

            System.out.println(String.valueOf(array[1]) + array[3] + array[0] + array[2] + array[4]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[0] + array[4] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[2] + array[0] + array[4]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[2] + array[4] + array[0]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[4] + array[0] + array[2]);
            System.out.println(String.valueOf(array[1]) + array[3] + array[4] + array[2] + array[0]);



            System.out.println(String.valueOf(array[2]) + array[4] + array[0] + String.valueOf(array[1]) + array[3]);
            System.out.println(String.valueOf(array[2]) + array[4] + array[0] + array[3] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[2]) + array[4] + String.valueOf(array[1]) + array[0] + array[3]);
            System.out.println(String.valueOf(array[2]) + array[4] + String.valueOf(array[1]) + array[3] + array[0]);
            System.out.println(String.valueOf(array[2]) + array[4] + array[3] + array[0] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[2]) + array[4] + array[3] + String.valueOf(array[1]) + array[0]);

            System.out.println(String.valueOf(array[2]) + array[0] + array[4] + String.valueOf(array[1]) + array[3]);
            System.out.println(String.valueOf(array[2]) + array[0] + array[4] + array[3] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[2]) + array[0] + String.valueOf(array[1]) + array[4] + array[3]);
            System.out.println(String.valueOf(array[2]) + array[0] + String.valueOf(array[1]) + array[3] + array[4]);
            System.out.println(String.valueOf(array[2]) + array[0] + array[3] + array[4] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[2]) + array[0] + array[3] + String.valueOf(array[1]) + array[4]);

            System.out.println(String.valueOf(array[2]) + String.valueOf(array[1]) + array[0] + array[4] + array[3]);
            System.out.println(String.valueOf(array[2]) + String.valueOf(array[1]) + array[0] + array[3] + array[4]);
            System.out.println(String.valueOf(array[2]) + String.valueOf(array[1]) + array[4] + array[0] + array[3]);
            System.out.println(String.valueOf(array[2]) + String.valueOf(array[1]) + array[4] + array[3] + array[0]);
            System.out.println(String.valueOf(array[2]) + String.valueOf(array[1]) + array[3] + array[0] + array[4]);
            System.out.println(String.valueOf(array[2]) + String.valueOf(array[1]) + array[3] + array[4] + array[0]);

            System.out.println(String.valueOf(array[2]) + array[3] + array[0] + String.valueOf(array[1]) + array[4]);
            System.out.println(String.valueOf(array[2]) + array[3] + array[0] + array[4] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[2]) + array[3] + String.valueOf(array[1]) + array[0] + array[4]);
            System.out.println(String.valueOf(array[2]) + array[3] + String.valueOf(array[1]) + array[4] + array[0]);
            System.out.println(String.valueOf(array[2]) + array[3] + array[4] + array[0] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[2]) + array[3] + array[4] + String.valueOf(array[1]) + array[0]);




            System.out.println(String.valueOf(array[3]) + array[4] + array[0] + String.valueOf(array[1]) + array[2]);
            System.out.println(String.valueOf(array[3]) + array[4] + array[0] + array[2] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[3]) + array[4] + String.valueOf(array[1]) + array[0] + array[2]);
            System.out.println(String.valueOf(array[3]) + array[4] + String.valueOf(array[1]) + array[2] + array[0]);
            System.out.println(String.valueOf(array[3]) + array[4] + array[2] + array[0] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[3]) + array[4] + array[2] + String.valueOf(array[1]) + array[0]);

            System.out.println(String.valueOf(array[3]) + array[0] + array[4] + String.valueOf(array[1]) + array[2]);
            System.out.println(String.valueOf(array[3]) + array[0] + array[4] + array[2] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[3]) + array[0] + String.valueOf(array[1]) + array[4] + array[2]);
            System.out.println(String.valueOf(array[3]) + array[0] + String.valueOf(array[1]) + array[2] + array[4]);
            System.out.println(String.valueOf(array[3]) + array[0] + array[2] + array[4] + String.valueOf(array[1]));
            System.out.println(String.valueOf(array[3]) + array[0] + array[2] + String.valueOf(array[1]) + array[4]);

            System.out.println(String.valueOf(array[3]) + String.valueOf(array[1]) + array[4] + array[0] + array[2]);
            System.out.println(String.valueOf(array[3]) + String.valueOf(array[1]) + array[4] + array[2] + array[0]);
            System.out.println(String.valueOf(array[3]) + String.valueOf(array[1]) + array[2] + array[4] + array[0]);
            System.out.println(String.valueOf(array[3]) + String.valueOf(array[1]) + array[2] + array[0] + array[4]);
            System.out.println(String.valueOf(array[3]) + String.valueOf(array[1]) + array[0] + array[4] + array[2]);
            System.out.println(String.valueOf(array[3]) + String.valueOf(array[1]) + array[0] + array[2] + array[4]);

            System.out.println(String.valueOf(array[3]) + array[2] + array[4] + array[0] + array[1]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[4] + array[1] + array[0]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[0] + array[4] + array[1]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[0] + array[1] + array[4]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[1] + array[4] + array[0]);
            System.out.println(String.valueOf(array[3]) + array[2] + array[1] + array[0] + array[4]);
        }
    }
}
