package Random;

import java.util.HashSet;
import java.util.Scanner;

public class VeraAndLCS {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            alphabet[a.charAt(i) - 'a']++;
        }
        char c = 'a';
        for (int i = 1; i < 26; i++) {
            if (alphabet[i] < alphabet[c - 'a']) {
                c = (char) ('a' + i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.substring(n-k));
        for (int i = 0; i < n - k; i++) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
