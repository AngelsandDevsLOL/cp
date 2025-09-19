package Random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PortalsCheck {
    public static int[] parent;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        parent = new int[100000];
        for (int o = 0; o < 5; o++) {
            int n = sc.nextInt();
            sc.nextLine();
            HashMap<String, Integer> hMap = new HashMap();
            Arrays.fill(parent, -1);
            int count = 0;
            for (int i = 0; i < n; i++) {
                String[] input = sc.nextLine().split(" ");
                if (!hMap.containsKey(input[1])) {
                    hMap.put(input[1], count++);
                }
                if (!hMap.containsKey(input[2])) {
                    hMap.put(input[2], count++);
                }
                int p1 = find(hMap.get(input[1]));
                int p2 = find(hMap.get(input[2]));
                if (input[0].equals("p")) {
                    if (p1 != p2) {
                        parent[p1] = p2;
                    }
                } else {
                    if (p1 != p2) {
                        System.out.println("not connected");
                    } else {
                        System.out.println("connected");
                    }
                }
            }
        }
    }
    public static int find(int num) {
        if (parent[num] == -1) return num;
        parent[num] = find(parent[num]);
        return parent[num];
    }
}
