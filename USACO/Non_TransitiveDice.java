package USACO;

import java.util.HashSet;
import java.util.Scanner;

//Non-Transitive Dice
public class Non_TransitiveDice {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            boolean bool = true;
            HashSet<Integer> hSet = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                hSet.add(j+1);
            }
            int aLowest = 10;
            int aHighest = 0;
            int bLowest = 10;
            int bHighest = 0;
            for (int j = 0; j < 4; j++) {
                int x = scanner.nextInt();
                if (!hSet.contains(x)) {
                    continue;
                } else {
                    hSet.remove(x);
                    if (x < aLowest) {
                        aLowest = x;
                    } if (x > aHighest) {
                        aHighest = x;
                    }
                }
            }
            for (int j = 0; j < 4; j++) {
                int x = scanner.nextInt();
                if (!hSet.contains(x)) {
                    continue;
                } else {
                    hSet.remove(x);
                    if (x < aLowest) {
                        bLowest = x;
                    } if (x > aHighest) {
                        bHighest = x;
                    }
                }
            }
            int cLargest = 0;
            int cSmallest = 10;
            if (bool) {
                for (int integer : hSet) {
                    if (integer < cSmallest) {
                        cSmallest = integer;
                    } if (integer > cLargest) {
                        cLargest = integer;
                    }
                }
            }
            if (bool && aHighest > bLowest && bHighest > cSmallest && cLargest > aLowest) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
