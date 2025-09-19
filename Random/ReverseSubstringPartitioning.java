package Random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseSubstringPartitioning {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String x = sc.nextLine();
        if (n >= 2 && x.charAt(0) != x.charAt(n - 1)) {
            System.out.println(n);
            return;
        }
        Deque<Character> d = new LinkedList<>();
        d.add(x.charAt(0));
        int count = 0;
        for (int i = 1; i < x.length(); i++) {
            if (d.getLast() == x.charAt(i)) {
                count++;
            } else {
                d.add(x.charAt(i));
            }
        }
        while (true) {
            int num = d.removeFirst();
            if (!d.isEmpty() && d.getLast() == num) count++;
            else break;
        }
        System.out.println(n - count);
    }
}
