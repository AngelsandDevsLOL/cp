package CCC.MockS;

import java.util.Scanner;

public class problemsettingpandemonium {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] freq = new int[100000];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int dif = sc.nextInt();
            if (++freq[dif] > max) max = freq[dif];
        }
        System.out.println(max);
    }
}
