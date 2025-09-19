package NoContest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class JamesRectangles {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair[] ar = new Pair[n];
        HashSet<Pair> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            ar[i] = new Pair(x, y);
            hSet.add(new Pair(x, y));
        }
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i+1; j < ar.length; j++) {
                for (int k = j+1; k < ar.length; k++) {
                    Pair p1 = ar[i];
                    Pair p2 = ar[j];
                    Pair p3 = ar[k];
                    double num1 = (p1.y - p2.y);
                    double num2 = (p1.y-p3.y);
                    double denom1 = (p1.x - p2.x);
                    double denom2 = (p1.x-p3.x);
                    if ((num1 * num2)/ (denom1 * denom2) == -1.0) {
                        double b1 = p3.y - p3.x * (num1 / denom1);
                        double b2 = p2.y-p2.x*(num2/denom2);
                        double x = (b2 - b1) / ((num1/denom1) - (num2/denom2));
                        double y = num1/denom1 * x + b1;
                        if (hSet.contains(new Pair(x, y))) {
                            count++;
                        }
                    } else if ((num1 == 0 && denom2 == 0)) {
                        if (hSet.contains(new Pair(p3.x,p2.y))) {
                            count++;
                        }
                    } else if ((num2 == 0 && denom1 == 0)) {
                        if (hSet.contains(new Pair(p2.x,p3.y))) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
    static class Pair {
        double x;
        double y;
        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Double.compare(pair.x, x) == 0 && Double.compare(pair.y, y) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
