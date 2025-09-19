package Random;

import java.util.Scanner;

public class HungerBar {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), a = sc.nextInt(), s = sc.nextInt();
        System.out.println(Math.max(Math.min(h,a)-s,0));
    }
}
