package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class Fix {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] array = new String[3];
            array[0] = scanner.nextLine();
            array[1] = scanner.nextLine();
            array[2] = scanner.nextLine();
            Arrays.sort(array);
            boolean bool = false;
            if (prefix(array[0], array[1]) || prefix(array[0], array[2]) || prefix(array[1], array[2]) || prefix(array[1], array[0]) || prefix(array[2], array[0]) || prefix(array[2], array[1])) {
                bool = true;
            }
            if (suffix(array[0],array[1]) || suffix(array[0],array[2]) || suffix(array[1],array[2]) || suffix(array[1],array[0]) || suffix(array[2],array[1]) || suffix(array[2],array[0])){
                bool = true;
            }
            if (bool){
                System.out.println("No");
            } else
                System.out.println("Yes");
        }
    }

    static boolean prefix(String x, String y) {
        int length = x.length()-1;
        if (length > y.length()-1){
            length = y.length()-1;
        }
        boolean bool = false;
        if (y.substring(0, length).equals(x)) {
            bool = true;
        }
        return bool;
    }

    static boolean suffix(String x, String y) {
        int length = x.length();
        if (length > y.length()){
            length = y.length();
        }
        boolean bool = false;
        if (y.substring(y.length()-length, y.length()).equals(x)) {
            bool = true;
        }
        return bool;
    }
}
