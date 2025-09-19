package Random;

import java.util.Scanner;

public class BubbleTea {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] thing = new int[n];
        for (int i = 0; i < n; i++) {
            thing[i] = sc.nextInt();
        }
        double[] anotherThing = new double[n];
        anotherThing[0] = thing[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                anotherThing[1] = thing[1] + anotherThing[0];
                anotherThing[1] = Math.min(anotherThing[1], Math.max(thing[1], thing[0]) + Math.min(thing[1], thing[0]) * 0.75);
            } else if (i == 2) {
                anotherThing[i] = thing[i] + anotherThing[i - 1];
                anotherThing[i] = Math.min(anotherThing[i], Math.max(thing[i], thing[i - 1]) + Math.min(thing[i], thing[i - 1]) * 0.75 + anotherThing[i - 2]);
                anotherThing[i] = Math.min(anotherThing[i], thing[i - 2] + thing[i - 1] + thing[i] - Math.min(thing[i - 2], Math.min(thing[i - 1], thing[i]))/2.0);
            } else  {
                anotherThing[i] = thing[i] + anotherThing[i - 1];
                anotherThing[i] = Math.min(anotherThing[i], Math.max(thing[i], thing[i - 1]) + Math.min(thing[i], thing[i - 1]) * 0.75 + anotherThing[i - 2]);
                anotherThing[i] = Math.min(anotherThing[i], thing[i - 2] + thing[i - 1] + thing[i] - Math.min(thing[i - 2], Math.min(thing[i - 1], thing[i]))/2.0 + anotherThing[i - 3]);
            }
        }
        System.out.println((int)anotherThing[n -1]);
    }
}
