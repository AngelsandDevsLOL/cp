package DMOPC;

import java.util.*;

public class HatSwap {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // hat colour people
        int m = scanner.nextInt();
        int[] ar = new int[n];
        int[] count = new int[n];
        ArrayList<Integer>[] aList = new ArrayList[n];
        ArrayList<Integer>[] locationOfHats = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            aList[i] = new ArrayList<>();
            locationOfHats[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt(); // hat colour
            count[ar[i]-1]++; // index hat colour - 1
            locationOfHats[ar[i]-1].add(i+1); // this guy has a hat colour at this index
        }
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            aList[a].add(b);
            aList[b].add(a); // node goes to ...
        }
        int destination = n - 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) { // bfs for first guy
            int current = q.poll();
            ArrayList<Integer> aL = aList[current];
            if (aL != null) {
                for (int i : aL) {
                    if (!vis[i]) {
                        q.add(i);
                        dis[i] = dis[current] + 1;
                        vis[i] = true;
                    }
                }
            }
        }
        boolean[] vis2 = new boolean[n];
        int[] dis2 = new int[n];
        q = new LinkedList<>();
        q.add(destination);
        vis2[destination] = true;
        while (!q.isEmpty()) { // bfs for second guy
            int current = q.poll();
            ArrayList<Integer> aL = aList[current];
            if (aL != null) {
                for (int i : aL) {
                    if (!vis2[i]) {
                        q.add(i);
                        dis2[i] = dis2[current] + 1;
                        vis2[i] = true;
                    }
                }
            }
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                ArrayList<Integer> al = locationOfHats[i]; // location of current nodes
                int bestDis = Integer.MAX_VALUE;
                int secondDis = Integer.MAX_VALUE;
                int indexToNode = 0;
                int bestDis2 = Integer.MAX_VALUE;
                int secondDis2 = Integer.MAX_VALUE;
                int indexToNode2 = 0;
                for (int j : al) {
                    if (dis[j-1] < bestDis) {
                        secondDis = bestDis;
                        bestDis = dis[j-1];
                        indexToNode = j + 1;
                    } else if (dis[j-1] == bestDis) {
                        secondDis = bestDis;
                    } else {
                        secondDis = Math.min(secondDis, dis[j-1]);
                    }
                    if (dis2[j-1] < bestDis2) {
                        secondDis2 = bestDis2;
                        bestDis2 = dis2[j-1];
                        indexToNode2 = j + 1;
                    } else if (dis2[j-1] == bestDis2) {
                        secondDis2 = bestDis2;
                    } else {
                        secondDis2 = Math.min(secondDis2, dis2[j-1]);
                    }
                }
                if (indexToNode != indexToNode2) {
                    smallest = (bestDis2 + bestDis);
                } else {
                    smallest = (Math.min(bestDis+ secondDis2, secondDis+ bestDis2));
                }
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(smallest);
        }
    }
}
