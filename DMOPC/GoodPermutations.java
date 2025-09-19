package DMOPC;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GoodPermutations {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        ArrayList<Integer>[] multiples = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
            edges[i] = new ArrayList<>();
            multiples[i] = new ArrayList<>();
        }
        multiples[n] = new ArrayList<>();
        edges[n] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> aList = primeFactorize(ar[i]);
            for (int x : aList) {
                multiples[x].add(ar[i]); // 2: 6, 2, 4
            }
        }
        int[] out = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 2; i < multiples.length; i++) {
            ArrayList<Integer> aList = multiples[i];
            for (int j = aList.size()-1; j > 0; j--) {
                edges[aList.get(j-1)].add(aList.get(j));
                out[aList.get(j)]++;
            }
            pq.add(i * -1);
        }
        while (!pq.isEmpty()) {
            int x = pq.poll() * -1;
            if (out[x] == 0) {
                System.out.print(x + " ");
                for (int i : edges[x]) {
                    out[i]--;
                    pq.add(i);
                }
            }
        }
        System.out.println(1);
    }
    public static ArrayList<Integer> primeFactorize(int x) {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 2; i < x/2+1; i++) {
            while (x % i == 0) {
                x = x / i;
                if (!aList.contains(i)) {
                    aList.add(i);
                }
            }
        }
        return aList;
    }
}