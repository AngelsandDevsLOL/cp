package Arcadia;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class HackingGrades2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] fraction = new int[n][2];
        TreeMap<Double, TreeSet<Integer>> tMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            fraction[i][0] = sc.nextInt();
        }
        double[] grades = new double[n];
        int[] inc = new int[n];
        for (int i = 0; i < n; i++) {
            fraction[i][1] = sc.nextInt();
        }
        Arrays.sort(fraction, (x, y) -> Integer.compare(x[1] - x[0], y[1] - y[0]));
        for (int i = 0; i < n; i++) {
            if (fraction[i][0] == fraction[i][1]) continue;
            double key = -((fraction[i][0] + 1) / (double) (fraction[i][1] + 1)) + (fraction[i][0] / (double) fraction[i][1]);
            if (tMap.containsKey(key)) tMap.get(key).add(i);
            else {
                TreeSet<Integer> tSet = new TreeSet<>();
                tSet.add(i);
                tMap.put(key, tSet);
            }
            grades[i] = key;
        }
        for (int i = 0; i < k; i++) {
            for (Double x : tMap.keySet()) {
                int index;
                if (tMap.get(x).size() == 1) { index = tMap.get(x).higher(-1); tMap.remove(x); }
                else {
                    index = tMap.get(x).higher(-1);
                    tMap.get(x).remove(index);
                }
                fraction[index][0]++; fraction[index][1]++;
                double next = -((fraction[index][0] + 1) / (double) (fraction[index][1] + 1)) + (fraction[index][0] / (double) fraction[index][1]);
                if (tMap.containsKey(next)) tMap.get(next).add(index);
                else {
                    TreeSet<Integer> tSet = new TreeSet<>();
                    tSet.add(index);
                    tMap.put(next, tSet);
                }
                grades[index] = fraction[index][0] / (double) fraction[index][1];
                inc[index]++;
                break;
            }
        }
        double finalAns = 0;
        for (int i = 0; i < n; i++) {
            finalAns += (fraction[i][0]) / (double) (fraction[i][1]);
        }
        System.out.println(finalAns / n * 100);
    }
}
