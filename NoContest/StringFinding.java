package NoContest;

import java.util.Scanner;

public class StringFinding {
    static long mod = (long) (1e9 + 7);
    public static void main (String[] args) {
        long x = 29;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String find = sc.nextLine();
        long findNum = 0;
        long cur = 0;
        int power = 1;
        for (int i = 0; i < find.length(); i++) {
            cur = cur * x + (input.charAt(i) - 'a');
            cur %= mod;
            findNum = findNum * x + (find.charAt(i) - 'a');
            findNum %= mod;
            power *= x;
            power %= mod;
        }
        boolean bool = false;
        if (cur == findNum) {
            bool = true;
            System.out.println(0);
        }
        for (int i = 0; i + find.length() < input.length() & !bool; i++) {
            long num = (long) (input.charAt(i) - 'a') * power;
            cur -= (num);
            cur %= mod;
            cur += mod;
            cur %= mod;
            cur *= x;
            cur %= mod;
            cur += input.charAt(i + find.length()) - 'a';
            if (cur == findNum) {
                bool = true;
                System.out.println(i + 1);
            }
        }
        if (!bool) System.out.println(-1);
    }
}
