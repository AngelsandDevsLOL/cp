package CCC;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TandemBicycle2 {
    public static void main(String args[]) {
        //
        Scanner scanner = new Scanner(System.in);
        int questionNumber = scanner.nextInt();
        int citizensNumber = scanner.nextInt();
        scanner.nextLine();
        String[] dmojistanSpeed = scanner.nextLine().split(" ");
        String[] peglandSpeed = scanner.nextLine().split(" ");
        int[] speedOfDmojistan = new int[dmojistanSpeed.length];
        Integer[] speedOfPegland = new Integer[peglandSpeed.length];
        for (int x = 0; x < dmojistanSpeed.length; x++) {
            speedOfDmojistan[x] = Integer.parseInt(dmojistanSpeed[x]);
            speedOfPegland[x] = Integer.parseInt(peglandSpeed[x]);
        }
        int[] maximumSpeed = new int[citizensNumber];
        int[] minimumSpeed = new int[citizensNumber];
        Arrays.sort(speedOfDmojistan);

        if (questionNumber == 1) {
            Arrays.sort(speedOfPegland);
            for (int x = 0; x < citizensNumber; x++) {
                if (speedOfDmojistan[x] < speedOfPegland[x]) {
                    maximumSpeed[x] = speedOfPegland[x];
                } else
                    maximumSpeed[x] = speedOfDmojistan[x];
            }
        } else if (questionNumber == 2) {
            Arrays.sort(speedOfPegland);
            Arrays.sort(speedOfPegland, Collections.reverseOrder());
            for (int x = 0; x < citizensNumber; x++) {
                if (speedOfDmojistan[x] < speedOfPegland[x]) {
                    minimumSpeed[x] = speedOfPegland[x];
                } else
                    minimumSpeed[x] = speedOfDmojistan[x];
            }
        }
        int sum = 0;
        if (questionNumber == 2) {
            for (int x = 0; x < citizensNumber; x++) {
                sum = sum + minimumSpeed[x];
            }
        }
        else if (questionNumber == 1){
            for (int x = 0;x<citizensNumber;x++){
                sum = sum + maximumSpeed[x];
            }
        }
        System.out.println(sum);
    }
}