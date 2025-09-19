package Random;

import java.util.Scanner;

public class WesleysAnger {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input1.substring(i,i+1).equals("S") && input2.substring(i,i+1).equals("S")) {
                count++;
                if (count > 2) {
                    break;
                }
            }
        }
        if (count > 2) System.out.println("NO");
        else System.out.println("YES");
    }
}
