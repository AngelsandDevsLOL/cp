package CCC.MockS;

import java.util.Scanner;

public class ColorfulStrings {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] ar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'a']++;
        }
        long count = 1;
        for (int i = 0; i < 26; i++) {
            count *= (ar[i] + 1);
            count %= 1e9 + 7;
        }
        System.out.println(count);
    }
}
