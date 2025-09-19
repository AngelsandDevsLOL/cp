package CCC.Senior;

import java.util.*;

public class GoodTriplets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c = sc.nextInt();
        int[] input = new int[n * 2];
        int[] index = new int[c * 2];
        for (int i = 0; i < 2 * n; i+=2) {
            int num = sc.nextInt();
            input[i] = num;
            input[i + 1] = num + c;
            index[num]++;
            index[num + c]++;
        }
        Arrays.sort(input);
        long ans = (long) n * (n - 1) * (n - 2) / 6;
        long subtract = 0;
        int j = 1;
        for (int i = 0; i < n; i++) {
            while (j < 2 * n && input[j] - input[i] <= c / 2) {
                j++; // [i, j)
            }
            long temp = j - i - 1;
            subtract += (temp * (temp - 1)) / 2;
        }
        ans -= subtract;
        if (c % 2 == 0) {
            for (int i = 0; i < c / 2; i++) {
                ans += (long) index[i] * (index[i] - 1) * index[i + c/2] / 2;
                ans += (long) index[i] * index[i + c/2] * (index[i + c/2] - 1) / 2;
            }
        }
        System.out.println(ans);
    }
}
