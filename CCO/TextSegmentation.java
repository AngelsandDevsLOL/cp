package CCO;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class TextSegmentation {
    public static long[] exp = new long[21];
    public static int base = 31;
    public static int mod = (int) (1e9 + 7);
    public static Stack<Short>[] stack;
    public static String[] index;
    public static void main (String[] args) {
        exp[0] = 1;
        for (int i = 1; i <= 20; i++) {
            exp[i] = (exp[i - 1] * base) % mod;
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        index = new String[n];
        HashMap<Long, Short> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long ans = 0;
            String dictionary = sc.nextLine();
            index[i] = dictionary;
            for (int j = 0; j < dictionary.length(); j++) {
                ans *= base;
                ans += dictionary.charAt(j) - 'a' + 1;
                ans %= mod;
            }
            hMap.put(ans, (short) i);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= m; i++) {
            String input = sc.nextLine();
            stack = new Stack[input.length() + 1];
            long[] ar = new long[input.length() + 1];
            for (int j = 1; j <= input.length(); j++) {
                ar[j] = (ar[j - 1] * base + input.charAt(j - 1) - 'a' + 1) % mod;
            }
            Stack<Short> ans = min(ar, hMap, 1);
            if (ans.size() == 0) System.out.println("***" + input);
            else {
                while (ans.size() > 1) {
                    System.out.print(index[ans.pop()] + " ");
                }
                System.out.println(index[ans.pop()]);
            }
        }
    }
    public static Stack<Short> min (long[] ar, HashMap<Long, Short> hMap, int left) { // leftBound
        if (left == ar.length) {
            return new Stack<>();
        }
        if (stack[left] != null) return stack[left];
        Stack<Short> temp = new Stack<>();
        for (int i = Math.min(ar.length - 1, left + 19); i >= left; i--) {
            if (hMap.containsKey(((ar[i] - ((ar[left - 1] * exp[i - left + 1]) % mod) + mod) % mod))) {
                Stack<Short> ans = min(ar, hMap, i + 1);
                if (ans.isEmpty() && i == ar.length - 1) {
                    temp.push(hMap.get(((ar[i] - ((ar[left - 1]) * exp[i - left + 1] % mod) + mod) % mod)));
                    return stack[left] = temp;
                }
                if (ans.isEmpty()) {
                    continue;
                }
                if (temp.isEmpty() || ans.size() < temp.size() - 1) {
                    temp = new Stack<>();
                    temp.addAll(ans);
                    temp.push(hMap.get(((ar[i] - ((ar[left - 1]) * exp[i - left + 1] % mod) + mod) % mod)));
                }
            }
        }
        return stack[left] = temp;
    }
}