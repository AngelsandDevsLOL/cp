package CCC.Senior;

import java.util.HashSet;
import java.util.Scanner;

public class From1987to2013 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt() + 1;
        while (true) {
            HashSet<String> hSet = new HashSet<>();
            for (int i = 0; i < String.valueOf(y).length(); i++) {
                hSet.add(String.valueOf(y).substring(i,i+1));
            }
            if (hSet.size() == String.valueOf(y).length()) {
                System.out.println(y);
                break;
            }
            y++;
        }
    }
}
