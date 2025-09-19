package COCI;

import java.util.Scanner;

public class Krokods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] letters = new int[4];
        sc.nextLine();
        String input = sc.nextLine();
        for (int j = 0; j < n; j++) {
            if (input.charAt(j) == 'k') {
                letters[0]++;
            } else if (input.charAt(j) == 'r') {
                letters[1]++;
            } else if (input.charAt(j) == 'o') {
                letters[2]++;
            } else {
                letters[3]++;
            }
        }
        int cur = calculate(letters);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m - i; j++) {
                for (int k = 0; k <= m - i - j; k++) {
                    for (int l = 0; l <= m - i - j - k; l++) {
                        letters[0] += i;
                        letters[1] += j;
                        letters[2] += k;
                        letters[3] += l;
                        cur = Math.max(calculate(letters), cur);
                        letters[0] -= i;
                        letters[1] -= j;
                        letters[2] -= k;
                        letters[3] -= l;
                    }
                }
            }
        }
        System.out.println(cur);
    }
    public static int calculate (int[] letters) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += letters[i] * letters[i];
        }
        int smallest = letters[0] / 2;
        smallest = Math.min(smallest, letters[1]);
        smallest = Math.min(smallest, letters[2] / 2);
        smallest = Math.min(smallest, letters[3]);
        return sum + smallest * 7;
    }
}
