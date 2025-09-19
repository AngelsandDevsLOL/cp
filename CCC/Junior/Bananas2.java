package CCC.Junior;

import java.util.Scanner;

public class Bananas2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        while (!string.equals("X")) {
            while (true) {
                int indexA = string.indexOf("ANA");
                int indexB = string.indexOf("BAS");
                if (indexA == -1 && indexB == -1) {
                    break;
                } else {
                    if (indexA != -1) {
                        string = string.substring(0,indexA) + "A" + string.substring(indexA+3);
                    }
                    indexB = string.indexOf("BAS");
                    if (indexB != -1) {
                        string = string.substring(0,indexB) + "A" + string.substring(indexB+3);
                    }
                }
            }
            if (string.equals("A")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            string = scanner.nextLine();
        }
    }
}
