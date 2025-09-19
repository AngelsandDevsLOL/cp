package JOI;

import java.util.Scanner;
import java.util.TreeMap;

public class Semiexpress {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        k -= m;
        long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
        long t = sc.nextLong();
        int[] stations = new int[m];
        long ans = 0;
        sc.nextInt(); // station = 1 (first)
        for (int i = 1; i < m; i++) {
            stations[i] = sc.nextInt() - 1;
        }
        TreeMap<Long, Integer> extraK = new TreeMap<>();
        for (int i = 0; i < m - 1; i++) {
            if (stations[i] * b > t) break;
            ans++;
            long extra = (t - stations[i] * b) / a;
            if (extra < stations[i + 1] - stations[i]) {
                ans += extra;
                long temp = stations[i] + extra; // contains
                while (temp < stations[i + 1]) { // semi !!
                    long semi = (t - stations[i] * b) / c - extra; // extra if you take the semi
                    if (semi == 0) break;
                    if (semi + temp >= stations[i + 1]) {
                        long spare = stations[i + 1] - temp - 1;
                        if (extraK.containsKey(-spare)) extraK.put(-spare, extraK.get(-spare) + 1);
                        else extraK.put(-spare, 1);
                        break;
                    }
                    if (extraK.containsKey(-semi)) extraK.put(-semi, extraK.get(-semi) + 1);
                    else extraK.put(-semi, 1);
                }
            } else {
                ans += stations[i + 1] - stations[i];
            }
        }
        if (t >= b * (n - 1)) ans++; // lats station !
        for (long num : extraK.keySet()) {
            if (k <= 0) break;
            ans += Math.min(extraK.get(num), k) * -num;
            k -= extraK.get(num);
        }
        System.out.println(ans - 1);
    }
}
