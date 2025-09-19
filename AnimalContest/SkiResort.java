package AnimalContest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class SkiResort {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt(); // # of pandas
        ArrayList<Pair>[] difficulty = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            difficulty[i] = new ArrayList<>();
        }
        for (int i = 0; i < x - 1; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            difficulty[a].add(new Pair(b, scanner.nextInt()));
        }
        int[] skillLevel = new int[n];
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            int[] vis = new int[n];
            int pandaLevel = scanner.nextInt();
            stack.add(1);
            while (!stack.isEmpty()) {
                int cur = stack.pop()-1;
                ArrayList<Pair> dif = difficulty[cur];
                Collections.sort(dif);
                int integer = binarySearch(dif, 0, n, pandaLevel);
                if (integer != -1) {
                   // stack.add()
                }
            }
        }
    }
        public static int binarySearch(ArrayList<Pair> arr, int first, int last, int key) {
            int mid = (first + last) / 2;
            while (first <= last) {
                if (arr.get(mid).y < key) {
                    first = mid + 1;
                } else if (arr.get(mid).y == key) {
                    break;
                } else {
                    last = mid - 1;
                }
                mid = (first + last) / 2;
            }
            return mid;
        }

    static class Pair  implements Comparable<Pair> {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.y-o.y;
        }
    }
}
