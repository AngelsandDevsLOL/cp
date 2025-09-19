package CCC;

import java.util.*;

public class BoringBusiness {
    public static void main(String args[]) {
        HashSet<Pair> hSet = new HashSet<Pair>();
        hSet.add(new Pair(0, -1));
        hSet.add(new Pair(0, -2));
        hSet.add(new Pair(0, -3));
        hSet.add(new Pair(1, -3));
        hSet.add(new Pair(2, -3));
        hSet.add(new Pair(3, -3));
        hSet.add(new Pair(3, -4));
        hSet.add(new Pair(3, -5));
        hSet.add(new Pair(4, -5));
        hSet.add(new Pair(5, -5));
        hSet.add(new Pair(5, -4));
        hSet.add(new Pair(5, -3));
        hSet.add(new Pair(6, -3));
        hSet.add(new Pair(7, -3));
        hSet.add(new Pair(7, -4));
        hSet.add(new Pair(7, -5));
        hSet.add(new Pair(7, -6));
        hSet.add(new Pair(7, -7));
        hSet.add(new Pair(6, -7));
        hSet.add(new Pair(5, -7));
        hSet.add(new Pair(4, -7));
        hSet.add(new Pair(3, -7));
        hSet.add(new Pair(2, -7));
        hSet.add(new Pair(1, -7));
        hSet.add(new Pair(0, -7));
        hSet.add(new Pair(-1, -7));
        hSet.add(new Pair(-1, -6));
        hSet.add(new Pair(-1, -5));

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        boolean bool = true;
        int x = -1;
        int y = -5;
        while (!input[0].equals("q") && bool) {
            if (input[0].equals("d")) {
                for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                    y--;
                    if (hSet.contains(new Pair(x, y))) {
                        bool = false;
                        System.out.println(x + " " + (y - Integer.parseInt(input[1]) + i + 1) + " DANGER");
                    }
                    hSet.add(new Pair(x, y));
                }
                if (bool) {
                    System.out.println(x + " " + y + " safe");
                }
            } else if (input[0].equals("u")) {
                for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                    y++;
                    if (hSet.contains(new Pair(x, y))) {
                        bool = false;
                        System.out.println(x + " " + (y + Integer.parseInt(input[1]) - i - 1) + " DANGER");
                        break;
                    }
                    hSet.add(new Pair(x, y));
                }
                if (bool) {
                    System.out.println(x + " " + y + " safe");
                }
            } else if (input[0].equals("r")) {
                for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                    x++;
                    if (hSet.contains(new Pair(x, y))) {
                        bool = false;
                        System.out.println((x + Integer.parseInt(input[1]) - 1 - i) + " " + y + " DANGER");
                        break;
                    }
                    hSet.add(new Pair(x, y));
                }
                if (bool) {
                    System.out.println(x + " " + y + " safe");
                }
            } else { // left
                for (int i = 0; i < Integer.parseInt(input[1]); i++) {
                    x--;
                    if (hSet.contains(new Pair(x, y))) {
                        bool = false;
                        System.out.println((x - Integer.parseInt(input[1]) + 1 + i) + " " + y + " DANGER");
                        break;
                    }
                    hSet.add(new Pair(x, y));
                }
                if (bool) {
                    System.out.println(x + " " + y + " safe");
                }
            }
            input = scanner.nextLine().split(" ");
        }
    }
    static class Pair {
        int x;
        int y;
        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}