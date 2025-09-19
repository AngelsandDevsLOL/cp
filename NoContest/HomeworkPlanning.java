package NoContest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HomeworkPlanning {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            if (!q.isEmpty() && i - q.getFirst() >= w) {
                q.removeFirst();
                q.removeFirst();
            }
            while (!q.isEmpty() && q.getLast() <= d) {
                q.removeLast();
                q.removeLast();
            }
            q.add(i);
            q.add(d);
            if (i >= w - 1) {
                int index = q.removeFirst();
                int max = q.removeFirst();
                System.out.print(max + " ");
                q.addFirst(max);
                q.addFirst(index);
            }
        }
        System.out.println();
    }
}
