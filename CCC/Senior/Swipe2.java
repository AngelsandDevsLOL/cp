package CCC.Senior;

import java.util.*;

public class Swipe2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int pointer = 0;
        int prev = 0;
        Deque<Integer> L = new LinkedList<>();
        Stack<Integer> R = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (pointer < n && a[pointer] != b[i]) {
                pointer++;
            }
            if (pointer == n) {
                System.out.println("NO");
                return;
            }
            if (pointer > i) {
                if (prev == pointer && !L.isEmpty() && L.peekFirst() == pointer) {
                    continue;
                }
                L.add(i); L.add(pointer);
            } else if (pointer < i) {
                if (prev == pointer && !R.isEmpty() && R.peek() == pointer) {
                    R.pop();
                    R.pop();
                    R.push(i);
                    R.push(pointer);
                } else {
                    R.push(i); R.push(pointer);
                }
            }
            prev = pointer;
        }
        System.out.println("YES");
        System.out.println(L.size() / 2 + R.size() / 2);
        while (!L.isEmpty()) {
            System.out.println("L " + L.poll() + " " + L.poll());
        }
        while (!R.isEmpty()) {
            System.out.println("R " + R.pop() + " " + R.pop());
        }
    }
}