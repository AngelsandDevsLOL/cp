package LCC;

import java.util.HashSet;
import java.util.Scanner;

public class TeacherTroubles {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean headache = false;
        boolean bigheadache = false;
        HashSet<String> attendance = new HashSet<>(); // firstname
        HashSet<String> fullName = new HashSet<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("@");
            int x = input[0].indexOf(".");
            int y = 0;
            for (int j = input[0].length() - 1; j >= x; j--) {
                if (!(input[0].charAt(j) >= 48 && input[0].charAt(j) <= 57)) {
                    y = j;
                    break;
                }
            }
            String firstName = input[0].substring(0, x);
            String lastName = input[0].substring(x+1, y+1);
            System.out.println(firstName);
            System.out.println(lastName);
            if (attendance.contains(firstName)) {
                headache = true;
                if (fullName.contains(firstName + lastName)) {
                    bigheadache = true;
                    break;
                } else {
                    fullName.add(firstName + lastName);
                }
            } else {
                attendance.add(firstName);
                fullName.add(firstName + lastName);
            }
        }
        if (bigheadache) {
            System.out.println("BIG HEADACHE");
        } else if (headache) {
            System.out.println("HEADACHE");
        } else {
            System.out.println("NO HEADACHE");
        }
    }
}
