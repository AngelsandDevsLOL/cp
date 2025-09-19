package USACO;

import java.util.Scanner;
import java.util.Stack;

public class MeasuringTraffic {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //Stack<Lane> s = new Stack<>();
        /*
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("on")) {
                if (!s.isEmpty()) {
                    Lane cur = s.peek();
                    if (cur.x.equals("on")) {
                        s.pop();
                        s.add(new Lane(cur.x,cur.small+Integer.parseInt(input[1]), cur.large+Integer.parseInt(input[2])));
                    } else {
                        s.add(cur);
                    }
                } else {
                    s.add(new Lane(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                }
            } else if (input[0].equals("none")) {
                if (!s.isEmpty()) {
                    Lane cur = s.peek();
                    if (cur.x.equals("none")) {
                        s.pop();
                        s.add(new Lane(cur.x,Math.max(cur.small, Integer.parseInt(input[1])), Math.min(cur.large, Integer.parseInt(input[2]))));
                    } else {
                        s.add(cur);
                    }
                } else {
                    s.add(new Lane(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                }
            } else if (input[0].equals("off")) {
                if (!s.isEmpty()) {
                    Lane cur = s.peek();
                    if (cur.x.equals("off")) {
                        s.pop();
                        s.add(new Lane(cur.x,cur.small+Integer.parseInt(input[1]), cur.large+Integer.parseInt(input[2])));
                    } else {
                        s.add(cur);
                    }
                } else {
                    s.add(new Lane(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                }
            }
        }*/
        // stack -> actual tracking thing
        Lane[] ar = new Lane[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            ar[i] = new Lane(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }
        int small = -1;
        int large = -1;
        for (int i = 0; i < ar.length; i++) {
            if (small == -1 && !ar[i].x.equals("none")) continue;
            if (small == -1 && ar[i].x.equals("none")) {
                small = ar[i].small;
                large = ar[i].large;
            } else if (ar[i].x.equals("none")) {
                small = Math.max(small, ar[i].small);
                large = Math.min(large, ar[i].large);
                ar[i] = new Lane(ar[i].x, small, large);
            } else if (ar[i].x.equals("off")) {
                small = Math.max(small - ar[i].large,0);
                large = Math.max(large - ar[i].small,0);
            } else { // on
                small = small + ar[i].small;
                large = large + ar[i].large;
            }
        }
        final int s = small;
        final int l = large;
        for (int i = ar.length - 1; i >= 0; i--) {
            if (ar[i].x.equals("none")) {
                small = Math.max(small, ar[i].small);
                large = Math.min(large, ar[i].large);
                ar[i] = new Lane(ar[i].x, small, large);
            } else if (ar[i].x.equals("on")) {
                small = Math.max(small - ar[i].large,0);
                large = Math.max(large - ar[i].small,0);
            } else { // off
                small = small + ar[i].small;
                large = large + ar[i].large;
            }
        }
        System.out.println(small + " " + large);
        System.out.println(s + " " + l);
    }
    static class Lane {
        String x;
        int small;
        int large;
        public Lane (String x, int small, int large) {
            this.x = x;
            this.small = small;
            this.large = large;
        }
    }
}
