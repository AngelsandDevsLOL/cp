package CCC.Senior;

import java.util.*;

public class FloorPlan {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int maxFlooring = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        boolean[][] floor = new boolean[x][y];
        boolean[][] vis = new boolean[x][y];
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '.') {
                    floor[i][j] = true;
                }
            }
        }
        ArrayList<Integer> area = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!vis[i][j] && floor[i][j]) {
                    int count = 1;
                    vis[i][j] = true;
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i,j));
                    while (!q.isEmpty()) {
                        Pair pair = q.poll();
                        if (pair.x + 1 < x && !vis[pair.x+1][pair.y] && floor[pair.x+1][pair.y]) {
                            q.add(new Pair(pair.x + 1, pair.y));
                            count++;
                            vis[pair.x+1][pair.y] = true;
                        }
                        if (pair.y + 1 < y && !vis[pair.x][pair.y + 1] && floor[pair.x][pair.y + 1]) {
                            q.add(new Pair(pair.x, pair.y + 1));
                            count++;
                            vis[pair.x][pair.y + 1] = true;
                        }
                        if (pair.x - 1 >= 0 && !vis[pair.x-1][pair.y] && floor[pair.x-1][pair.y]) {
                            q.add(new Pair(pair.x-1, pair.y));
                            count++;
                            vis[pair.x-1][pair.y] = true;
                        }
                        if (pair.y - 1 >= 0 && !vis[pair.x][pair.y - 1] && floor[pair.x][pair.y - 1]) {
                            q.add(new Pair(pair.x, pair.y - 1));
                            count++;
                            vis[pair.x][pair.y - 1] = true;
                        }
                    }
                    area.add(count);
                }
            }
        }
        Collections.sort(area);
        int count = 0;
        for (int i = area.size()-1; i >= 0; i--) {
            if (maxFlooring - area.get(i) >= 0) {
                count++;
                maxFlooring = maxFlooring - area.get(i);
            } else {
                break;
            }
        }
        if (count == 1) {
            System.out.println(count + " room, " + maxFlooring + " square metre(s) left over");
        } else
        System.out.println(count + " rooms, " + maxFlooring + " square metre(s) left over");
    }
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
