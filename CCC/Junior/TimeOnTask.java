package CCC.Junior;

import java.util.Arrays;
import java.util.Scanner;

public class TimeOnTask {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int minutesAvaliable = scanner.nextInt();
        int choreChoices = scanner.nextInt();
        scanner.nextLine();
        int[] choreTime = new int[choreChoices];
        for (int x = 0; x < choreChoices; x++) {
            choreTime[x] = scanner.nextInt();
        }
        Arrays.sort(choreTime);

        int minutes = 0;
        int chores = 0;
        while ( minutes < minutesAvaliable){
            if (minutes + choreTime[chores] > minutesAvaliable){
                break;
            }
            chores = chores + 1;
            minutes = minutes + choreTime[chores-1];
        }

        System.out.println(chores);
    }
}
