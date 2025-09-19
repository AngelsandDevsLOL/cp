package COCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Geppetto {
    static int count = 1;
    static int n;
    static ArrayList<Integer>[] no;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        no = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            no[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            no[a].add(b);
            no[b].add(a);
        }
        recursion(new ArrayList<>(), 1);
        System.out.println(count);
    }
    static void recursion (ArrayList<Integer> forbidden, int cur) {
        if (n < cur) {
            return;
        }
        if (!forbidden.contains(cur)) {
            recursion((ArrayList<Integer>) forbidden.clone(), cur+1);
            for (int i : no[cur]) {
                forbidden.add(i);
            }
            count++;
            recursion((ArrayList<Integer>) forbidden.clone(), cur+1);
        } else {
            recursion((ArrayList<Integer>) forbidden.clone(), cur+1);
        }
        return;
    }
}
