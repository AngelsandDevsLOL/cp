package Arcadia;

import java.util.Scanner;

public class ScanTron {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        String b = sc.nextLine();
        int initial = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                initial++;
            }
        }
        int cur = initial;
        int ans = initial;
        for (int i = n - 2; i >= 0; i--) {
            if (a.charAt(i) == b.charAt(i)) cur--;
            if (a.charAt(i + 1) == b.charAt(i)) cur++;
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}
