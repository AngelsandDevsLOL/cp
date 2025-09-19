package Random;

import java.util.Scanner;

public class Palindrome {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        String x = sb.toString();
        int num = lcs(x, input);
        System.out.println(input.length() - num);
    }
    public static int lcs(String a, String b) {
        int[] ar = new int[a.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            int[] arr = new int[a.length() + 1];
            for (int j = 1; j <= a.length(); j++) {
                if (a.substring(i - 1,i).equals(b.substring(j - 1, j))) {
                    arr[j] = ar[j - 1] + 1;
                }
                arr[j] = Math.max(arr[j], arr[j - 1]);
                arr[j] = Math.max(arr[j], ar[j]);
            }
            ar = arr;
        }
        return ar[a.length()];
    }
}
