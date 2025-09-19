package CCC;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestSubstring {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Integer> aListA = new ArrayList();
        int index = input.indexOf('A');
        int index2 = input.lastIndexOf('Z');
        System.out.println(index2 - index + 1);
    }
}