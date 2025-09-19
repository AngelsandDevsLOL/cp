package Random;

import java.util.Scanner;

public class ATypicalCodeforcesProblem {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        boolean[] ar = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'Y') {
                ar[i] = true;
                count++;
            }
        }
        int temp = count;
        for (int i = 0; i < count; i++) {
            if (!ar[i]) temp++;
        }
        if (temp > n / 2) System.out.println("YES");
        else System.out.println("NO");
    }
}
