package WLMOJ;

import java.util.Scanner;

public class Portals {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == n) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
