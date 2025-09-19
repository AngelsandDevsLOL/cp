package Random;

import java.util.*;

public class SchoolExpansion {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pq = new PriorityQueue();
        long count = 0;
        long n = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong();
        for (int i = 1; i <= n; i++) {
            pq.add((a + i * b));
        }
        for (int i = 0; i < n; i++) {
            long num = pq.poll();
            count += num;
            pq.add(num + a);
        }
        System.out.println(count);
    }
}