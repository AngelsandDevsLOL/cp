package Random;

import java.util.Scanner;

public class PasswordAnger {
    static int n, m;
    static int count;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        recursion("");
        System.out.println(count);
    }
    public static void recursion(String str) {
        if (str.length() == n) {
            if (value(str) == m) count++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            recursion(str + (char) ('a' + i));
        }
    }
    public static int value(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 13 + s.charAt(i) - 'a' + 1;
        }
        return hash;
    }
}
