package USACO;

import java.util.Scanner;

public class SocialDistaincingI {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int d = 0;
        boolean[] barn = new boolean[n];
        int largest = 0;
        int secondLargest = 0;
        int count = 0;
        String input = scanner.nextLine();
        int beginning = 0;
        int ending = 0;
        int smallest = n;
        for (int i = 0; i < n; i++) {
            String cow = input.substring(i,i+1);
            if (cow.equals("1")) {
                barn[i] = true;
                if (count > largest) {
                    secondLargest = largest;
                    largest = count;
                } else if (count > secondLargest) {
                    secondLargest = count;
                }
                if (count < smallest && i != 0 && count != i) {
                    smallest = count;
                }
                count = 0;
            } else count++;
        }
        if (count > largest) {
            secondLargest = largest;
            largest = count;
        } else if (count > secondLargest) {
            secondLargest = count;
        }
        for (int i = 0; i < n; i++) {
            if (barn[i]) {
                beginning = i;
                break;
            }
        }
        for (int i = n-1; i >=0; i--) {
            if (barn[i]) {
                ending = n - i - 1;
                break;
            }
        }
        if (beginning == 0 && !barn[0]) {
            beginning = n;
        }
        if (ending == 0 && !barn[n-1]) {
            ending = n;
        }
        d = Math.max(d,(largest - 2) / 3); // both in largest
        d = Math.max(d, (int)(Math.min(Math.ceil(largest / 2.0)-1,Math.ceil(secondLargest / 2.0)-1))); // 1 in largest, 1 in secondLargest
        d = Math.max(d, (int)(Math.min(beginning-1,Math.ceil(largest / 2.0)-1))); // beginning, largest
        d = Math.max(d, (int)(Math.min(ending-1,Math.ceil(largest / 2.0)-1))); // ending,largest
        d = Math.max(d, (Math.min(count-1,beginning-1))); // beginning, ending but something in between
        if (beginning == n) { // beginning, ending, nothing 000000
            d = n - 2;
        } else {
            d = Math.max(d, (beginning - 3) / 3); // beginning, beginning
            d = Math.max(d, (ending - 3)/3); // ending, ending
        }
        d = Math.min(smallest, d); // if splitting them in half doesn't even work
        System.out.println(d+1);
    }
}
