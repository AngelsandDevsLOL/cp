package OTH;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MagicBarrier {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = sc.nextInt();
            }
        }
        PriorityQueue<Obj> ll = new PriorityQueue<>();
        PriorityQueue<Obj2> end = new PriorityQueue<Obj2>();
        int count = 0;
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt(), r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
            ll.add(new Obj(r1, c1, c2, k, count));
           // end.add(new Obj2(r2, k, count++));
        }
        while (!ll.isEmpty()) {
            
        }
    }
    public static class Obj implements Comparable{
        int roww;
        int col1; int col2;
        int findd;
        int index;
        public Obj (int row, int c1, int c2, int find, int ind) {
            roww = row; col1 = c1; col2 = c2; findd = find; index = ind;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(roww, ((Obj)o).roww);
        }
    }
    public static class Obj2 implements Comparable{
        int roww;
        int ind;
        int find;
        public Obj2 (int row, int c1, int c2, int find, int ind) {
          //  roww = row; col1 = c1; col2 = c2; findd = find; index = ind;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(roww, ((Obj)o).roww);
        }
    }
}
