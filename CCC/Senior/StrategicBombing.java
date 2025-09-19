package CCC.Senior;

import java.util.*;

public class StrategicBombing {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Integer>[] ar = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            ar[i] = new ArrayList<>();
        }
        while (!input.equals("**")) {
            char a = input.charAt(0);
            char b = input.charAt(1);
            int x = a - 65;
            int y = b - 65;
            ar[x].add(y);
            ar[y].add(x);
            input = scanner.nextLine();
        }
        int count = 0;
        HashSet<String> hSet = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            ArrayList<Integer> aList = ar[i];
            for (int j = 0; j < aList.size(); j++) {
                int value = ar[i].get(j);
                String string = String.valueOf((char)(i + 65)) + String.valueOf((char)(value + 65));
                if (!hSet.contains(string)) {
                    hSet.add(string);
                    int integer = ar[i].get(j);
                    ar[i].remove(j);
                    boolean bool = bfs(ar);
                    ar[i].add(j, integer);
                    if (!bool) {
                        count++;
                        System.out.println(string);
                    }
                }
            }
        }
        System.out.println("There are " + count + " disconnecting roads.");
    }
    static boolean bfs (ArrayList[] ar) {
        boolean[] vis = new boolean[26];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            ArrayList<Integer> aList = ar[x];
            for (int i : aList) {
                if (!vis[i]) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
        return vis[1];
    }
}
