package CCC.Senior;

import java.util.*;

public class MinimumCostFlow {
    public static int[] parent;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), d = sc.nextInt();
        ArrayList<Pair> aList = new ArrayList<>();
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 1; i <= m; i++) {
            aList.add(new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt(), i <= n - 1 ? 0 : 1));
        }
        Collections.sort(aList);
        int ans = 0, last = 0, lastw = 0;
        for (int i = 0; i < aList.size(); i++) {
            Pair p = aList.get(i);
            int fu = find(p.x), fv = find(p.y);
            if (fu != fv) {parent[fu] = fv; ans += p.b; last = i; lastw = p.a;}
        }
        if (aList.get(last).b == 1) {
            Arrays.fill(parent, -1);
            for (int i = 0; i < last; i++) {
                Pair p = aList.get(i);
                if (p.b == 0 || p.a < lastw) {
                    int py = find(p.y);
                    int px = find(p.x);
                    if (py != px) {
                        parent[px] = py;
                    }
                }
            }
            for (int i = last + 1; i < aList.size(); i++) {
                Pair p = aList.get(i);
                if (p.b == 0 && p.a <= d) {
                    if (find(p.x) != find(p.y)) {ans--; break;}
                }
            }
        }
        System.out.println(ans);
    }
    public static int find(int x) {
        if (parent[x] == -1) return x;
        parent[x] = find(parent[x]);
        return parent[x];

    }    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int a;
        int b;
        public Pair(int x, int y, int a, int b) {
            this.x = x;
            this.y = y;
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.a == a) {
                return Integer.compare(b, o.b);
            }
            return Integer.compare(a, o.a);
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
