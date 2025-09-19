package Random;

import java.util.*;

public class Rectangles {

    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String,Point> map=new HashMap<>();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            points.add(point);
            map.put(x+"-"+y,point);
        }
        int maxArea = 0;
        for (int i = 0; i < n - 2; i++) {
            Point point1 = points.get(i);
            for (int j = i + 1; j < n - 1; j++) {
                Point point2 = points.get(j);
                boolean sameX = point1.x == point2.x;
                boolean sameY = point1.y == point2.y;
                int len1 = 0;
                if (sameX) {
                    len1 = Math.abs(point1.y - point2.y);
                } else if (sameY) {
                    len1 = Math.abs(point1.x - point2.x);
                }
                if (len1 > 0) {
                    for (int q = j + 1; q < n; q++) {
                        Point point3 = points.get(q);
                        int area = 0;
                        if (sameX && point3.y == point1.y ) {
                            if (map.containsKey(point3.x+"-"+point2.y))
                                area = len1 * Math.abs(point3.x - point1.x);
                        } else if (sameX && point3.y == point2.y) {
                            if (map.containsKey(point3.x+"-"+point1.y))
                                area = len1 * Math.abs(point3.x - point2.x);
                        } else if (sameY && point3.x == point1.x) {
                            if (map.containsKey(point2.x+"-"+point3.y))
                                area = len1 * Math.abs(point3.y - point1.y);
                        } else if (sameY && point3.x == point2.x) {
                            if (map.containsKey(point1.x+"-"+point3.y))
                                area = len1 * Math.abs(point3.y - point2.y);
                        }
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    }
                }

            }
        }

        System.out.println(maxArea);
    }
}