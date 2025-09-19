package LCC;

import java.util.HashMap;
import java.util.Scanner;

public class Cookies {
    public static HashMap<Long, Integer> hMap = new HashMap<>();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(meth(n));
    }
    public static int meth (long num) {
        if (num <= 0) return 0;
        else if (num == 1) return 1;
        if (hMap.containsKey(num)) return hMap.get(num);
        int ans = 0;
        if (num % 2 == 0) ans += meth(num / 2);
        else ans += meth((num - 1) / 2);
        if (num % 3 == 0) ans += meth(num / 3);
        hMap.put(num, ans);
        return ans;
    }
}
