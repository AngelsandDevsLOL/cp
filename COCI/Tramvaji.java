package COCI;

import java.util.Scanner;

public class Tramvaji {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        sc.nextLine();
        for (int i = 0; i < n - 1; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("Patrik")) {
                ar[i+1] = Integer.parseInt(input[1]);
            } else {
                ar[i+1] = Integer.parseInt(input[2]) + ar[Integer.parseInt(input[1])-1];
            }
        }
        int count= ar[1];
        int x = 1;
        for (int i = 2; i < ar.length; i++) {
            if (ar[i]-ar[i-1] < count) {
                count = ar[i] - ar[i-1];
                x = i;
            }
        }
        System.out.println(count + " " + x + " " + (x+1));
    }
}
