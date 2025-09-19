package COCI;

import java.util.Scanner;

public class Malcom {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] ar = new int[21];
        int[] length = new int[n];
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            length[i] = name.length();
        }
        ar[length[0]]++;
        for (int i = 0, s = 0, e = 0; i < n; i++) {
            if (i - s > k) {
                ar[length[s]]--;
                s++;
            }
            while (e + 1 < n && e + 1 - i <= k) {
                ar[length[e + 1]]++;
                e++;
            }
            count += ar[length[i]] - 1;
        }
        System.out.println(count / 2);
    }
}
