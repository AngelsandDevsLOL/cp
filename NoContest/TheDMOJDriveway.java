package NoContest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TheDMOJDriveway {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), m = sc.nextInt();
        Deque<String> deque = new LinkedList<>();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[1].equals("in")) {
                deque.addLast(input[0]);
            } else {
                if (deque.getLast().equals(input[0])) {
                    deque.removeLast();
                } else if (m >= 1 && deque.getFirst().equals(input[0])) {
                    deque.removeFirst();
                    m--;
                }
            }
        }
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }
    }
}
