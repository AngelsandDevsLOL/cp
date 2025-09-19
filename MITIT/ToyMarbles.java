package MITIT;

import java.util.*;

public class ToyMarbles {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] colours = new int[n + 1];
        int[] current = new int[n + 1];
        int[] ar = new int[n + 1];
        HashMap<Integer, HashSet<Integer>> hMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (hMap.containsKey(c)) hMap.get(c).add(i + 1);
            else {
                HashSet<Integer> temp = new HashSet<>();
                temp.add(i + 1);
                hMap.put(c, temp);
            }
            colours[i + 1] = c;
            ar[i + 1] = i + 1;
            current[i + 1] = i + 1;
        }
        for (int key : hMap.keySet()) {
            if (hMap.get(key).size() == 1) continue;
            int ind = 0;
            if (hMap.get(key).contains(key)) {
                ind = key;
            }
            for (int num : hMap.get(key)) {
                if (ind == 0) ind = num;
                else if (ind == num) {}
                else {
                    colours[num] = 0;
                    q.add(2);
                    q.add(ind); q.add(num);
                    ar[num] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (current[i] == colours[i] || colours[i] == 0) continue;
            else if (colours[ar[colours[i]]] == colours[i] || colours[ar[colours[i]]] == 0) {
                q.add(2); q.add(colours[i]); q.add(current[i]);
                ar[current[i]] = 0;
                current[i] = colours[i];
                colours[i] = 0;
            } else {
                q.add(1); q.add(colours[i]); q.add(current[i]);
                int temp = current[i];
                current[i] = colours[i];
                current[ar[colours[i]]] = temp;

                ar[temp] = ar[colours[i]];
                ar[colours[i]] = i;
            }
        }
        System.out.println(q.size() / 3);
        while (!q.isEmpty()) {
            System.out.println(q.poll() + " " + q.poll() + " " + q.poll());
        }
    }
}
