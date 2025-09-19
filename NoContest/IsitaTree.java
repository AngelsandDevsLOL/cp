package NoContest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class IsitaTree {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> vertices = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();
        int edgesCount = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = scanner.nextInt();
                if (x == 1) {
                    vertices.add(i);
                    vertices.add(j);
                    if (edges.containsKey(j)) {
                        if (!edges.get(j).contains(i)) {
                            edgesCount++;
                            edges.get(j).add(i);
                        }
                    } else {
                        edgesCount++;
                        ArrayList<Integer> aList = new ArrayList<>();
                        aList.add(i);
                        edges.put(j, aList);
                    }
                    if (edges.containsKey(i)) {
                        if (!edges.get(i).contains(j)) {
                            edgesCount++;
                            edges.get(i).add(j);
                        }
                    } else {
                        edgesCount++;
                        ArrayList<Integer> aList = new ArrayList<>();
                        aList.add(j);
                        edges.put(i, aList);
                    }
                }
            }
        }
        if (edgesCount/2 == vertices.size()-1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
