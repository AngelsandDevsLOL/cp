package DMOPC;

import java.util.Scanner;

public class HomeRow {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int count = 0;
        while (count < s.length() && count < t.length() && (s.substring(count, count + 1).equals(t.substring(count, count+1)))) {
            count++;
        }
        System.out.println(t.length() - count + s.length() - count);
    }
}
