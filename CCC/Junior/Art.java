package CCC.Junior;

import java.util.Scanner;

public class Art {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int smallX = 100;
        int smallY = 100;
        int largeX = 0;
        int largeY = 0;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(",");
            if (Integer.parseInt(input[0]) > largeX) {
                largeX = Integer.parseInt(input[0]);
            } if (Integer.parseInt(input[0]) < smallX) {
                smallX = Integer.parseInt(input[0]);
            }
            if (Integer.parseInt(input[1]) > largeY) {
                largeY = Integer.parseInt(input[1]);
            } if (Integer.parseInt(input[1]) < smallY) {
                smallY = Integer.parseInt(input[1]);
            }
        }
        System.out.println(Math.max(0, smallX - 1) + "," + Math.max(0, smallY - 1));
        System.out.println(Math.min(100, largeX + 1) + "," + Math.min(100, largeY + 1));
    }
}
