package OTH;

import java.util.Scanner;

public class TallyClicker {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int second = n / 1111;
        int first = n - second * 1111;
        System.out.println(first + second);
    }
}
