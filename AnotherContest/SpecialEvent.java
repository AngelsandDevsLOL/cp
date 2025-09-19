package AnotherContest;

import java.util.ArrayList;
import java.util.Scanner;

public class SpecialEvent {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] days = new int[5];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'Y') days[j]++;
            }
        }
        ArrayList<Integer> aList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > max) {
                aList = new ArrayList<>();
                aList.add(i);
                max = days[i];
            } else if (days[i] == max) {
                aList.add(i);
            }
        }
        for (int i = 0; i < aList.size(); i++) {
            System.out.print(aList.get(i) + 1);
            if (i != aList.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
