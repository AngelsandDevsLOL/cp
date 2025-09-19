package YetAnotherContest;

import java.util.Scanner;

public class Explosion {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int prev = sc.nextInt();
        int maxLength = 1;
        int cur = 1;
        int length = 1;
        for (int i = 1; i < n; i++) {
            int input = sc.nextInt();
            if (Math.abs(prev - input) <= d) {
                length++;
            } else {
                cur++;
                maxLength = Math.max(maxLength, length);
                length = 1;
            }
            prev = input;
        }
        System.out.println(cur);
        System.out.println(Math.max(maxLength, length));
    }
}
