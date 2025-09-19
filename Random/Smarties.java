package Random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Smarties {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (hMap.containsKey(x)) hMap.put(x, hMap.get(x) + 1);
            else hMap.put(x, 1);
            q.add(x);
            while (hMap.size() >= k) {
                count += (n - i);
                int num = q.poll();
                if (hMap.get(num) == 1) hMap.remove(num);
                else hMap.put(num, hMap.get(num) - 1);
            }
        }
        System.out.println(count);
    }
}
