package WLMOJ;

import java.util.Scanner;

public class Knives {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), h = sc.nextInt();
        int dmg = 0;
        for (int i = 0; i < n; i++) {
            dmg += sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (x + h > dmg) count++;
        }
        System.out.println(count);
    }
}
