package CCC;

import java.util.*;

public class Swipe {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        TreeMap<Integer, TreeSet<Integer>> tMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (tMap.containsKey(a[i])) {
                tMap.get(a[i]).add(i);
            } else {
                TreeSet<Integer> tSet = new TreeSet<>();
                tSet.add(i);
                tMap.put(a[i], tSet);
            }
        }
        Deque<Objec> d = new LinkedList<>();
        int pointer = 0;
        boolean possible = true;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int newp;
            if (tMap.containsKey(num) && tMap.get(num).ceiling(pointer) != null) {
                newp = tMap.get(num).ceiling(pointer);
                if (newp == i) {
                    // do nothing
                } else if (newp == pointer && newp > i) {
                    // do nothing
                } else if (newp == pointer) { // newNum < i
                    d.addFirst(new Objec('R', newp, i));
                } else if (newp < i) {
                    d.addFirst(new Objec('R', newp, i));
                } else { // newNum > i
                    d.addLast(new Objec('L', newp, i));
                }
                pointer = newp;
            } else {
                possible = false;
                break;
            }
        }
        if (possible) {
            System.out.println("YES");
            System.out.println(d.size());
            while (!d.isEmpty()) {
                System.out.println(d.pollFirst());
            }
        } else {
            System.out.println("NO");
        }
    }
    public static class Objec {
        char c = 'L';
        int x;
        int y;
        public Objec (char cc, int xx, int yy) {
            c = cc;
            x = xx; y = yy;
        }

        @Override
        public String toString() {
            return (c + " " + x + " " + y);
        }
    }
}
