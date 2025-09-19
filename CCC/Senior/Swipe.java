package CCC.Senior;

import java.util.*;

public class Swipe {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        int n = sc.nextInt();
        int[] ar = new int[n]; // first line of input
        int[] ar2 = new int[n]; // second line of input
        for (int i = 0; i < n; i++) { // reading the first line
            ar[i] = sc.nextInt();
        }
        int pointer = 0; // pointer for the first line
        Stack<Pair> right = new Stack<>(); // swipes to the right, stored in a Stack
        Queue<Pair> left = new LinkedList<>(); // swipes to the left, stored in a Queue
        boolean works = true; // whether the program can turn line 1 -> line 2
        for (int i = 0; i < n; i++) { // runs through each element of line 2
            ar2[i] = sc.nextInt(); // reads the input for line 2
            if (i != 0 && ar2[i - 1] == ar2[i]) { // if previous element exists and it is equal to the current element,
                if (pointer == i - 1) {
                    right.add(new Pair(i - 1, i)); // add a right swipe to include the current element
                } else if (pointer < i - 1) {
                    right.peek().y++; // change the right swipe to include the current element
                }
            } else {
                works = false; // temporarily change "works" to false
                for (; pointer < n; pointer++) { // pointer to go through the first line
                    if (ar[pointer] == ar2[i]) { // number in first line is equal to number in second line
                        if (pointer > i) { // a left swipe should occur
                            left.add(new Pair(pointer, i)); // swipe to the left from pointer to i
                        } else if (pointer < i) { // a right swipe should occur
                            right.add(new Pair(pointer, i)); // swipe to the right from pointer to i
                        }
                        works = true; // if passes through this part of code, it still works
                        break; // breaks the for loop so it doesn't unnecessarily run
                    }
                }
                if (!works) break; // if doesn't work, breaks the for loop
            }
        }
        if (!works) { // doesn't work
            System.out.println("NO");
        } else {
            System.out.println("YES"); // does work
            System.out.println(left.size() + right.size()); // prints the # of swipes needed
            while (!left.isEmpty()) { // goes through the left swipes first
                Pair p = left.poll(); // removes the next element in the Queue
                System.out.println("L " + p.y + " " + p.x); // prints
            }
            while (!right.isEmpty()) { // goes through the right swipes first
                Pair p = right.pop(); // removes the next element in the Stack
                System.out.println("R " + p.x + " " + p.y); // prints
            }
        }
    }
    public static class Pair { // creating a Pair class
        int x; // has 2 variables in the class
        int y;
        public Pair (int xx, int yy) { // constructor
            x = xx;
            y = yy;
        }
    }
}
