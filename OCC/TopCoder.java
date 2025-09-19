package OCC;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TopCoder {
    public static int[] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        ar = new int[k];
        PriorityQueue<Triple> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            ar[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int[] temp = new int[k];
            for (int j = 0; j < k; j++) {
                temp[j] = sc.nextInt();
            }
            pq.add(new Triple(temp));
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            Triple t = pq.poll();
            for (int i = 0; i < k; i++) {
                if (t.cry[i] < ar[i]) {
                    System.out.println(ans); return;
                }
                ar[i] += t.cry[i];
            }
        }
        System.out.println(ans);
    }
    public static class Triple implements Comparable{
        int[] cry;
        public Triple (int[] input) {
            cry = input;
        }

        @Override
        public int compareTo(Object o) {
            for (int i = 0; i < cry.length; i++) {
                if (((Triple)o).cry[i] < ar[i]) return -1;
            }
            return 1;
        }
    }
}
