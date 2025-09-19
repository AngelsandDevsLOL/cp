package AlphaStar;

import java.util.Arrays;
import java.util.Scanner;

public class Outposts {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] post = new int[n + 1];
        for (int i = 0; i < n; i++) {
            post[i] = sc.nextInt();
        }
        Arrays.sort(post);
        int max = post[n];
        int num1 = (int) (12 * (Math.ceil(max / 12.0))) - max;
        int num2 = max - (int) (12 * Math.floor(max / 12.0));
        int[] dif = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            dif[i] = post[i] - post[i - 1];
        }
        int ans = max * 2;
        if (num1 < num2) {
            dif[n + 1] = (int) (12 * (Math.ceil(max / 12.0))); // use num1
            ans = dif[n + 1] * 2;
        }else {
            dif[n + 1] = (int) (12 * Math.floor(max / 12.0)); // use num2
            ans = Math.max(max, dif[n + 1]) * 2;
        }
        Arrays.sort(dif);
        for (int i = 0; i < k && dif[dif.length - i - 1] >= 12; i++) {
            int difference =  12 * (int)(Math.ceil(dif[dif.length - i - 1] / 12.0)) - dif[dif.length - i - 1];
            int difference2 =  dif[dif.length - i - 1] - 12 * (int)(Math.floor(dif[dif.length - i - 1] / 12.0));
            if (difference < 6) { // good!
                ans -= dif[dif.length - i - 1] - difference;
            } else {
                ans -= dif[dif.length - i - 1] - (difference2);
            }
        }
        System.out.println(ans);
    }
}
