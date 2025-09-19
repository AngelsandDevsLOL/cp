package SAC;

import java.util.Scanner;

public class ObligatoryGeometryProblem {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        String[] array = new String[n];
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("set")) {
                array[Integer.parseInt(input[2])-1] = input[1];
            } else {
                if (array[Integer.parseInt(input[2])-1] != null && array[Integer.parseInt(input[2])-1].equals(input[1])) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
