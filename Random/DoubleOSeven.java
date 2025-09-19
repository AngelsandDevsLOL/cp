package Random;

import java.util.Scanner;

public class DoubleOSeven {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int ammo1 = 0; // my ammo
        int ammo2 = 0; // other dude
        int score1 = 0;
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'B') {
                    ammo1++;
            } else if (input.charAt(i) == 'R') {
                ammo2++;
                if (ammo1 == 0) // reload
                {
                    ammo1++;
                }
                else {
                    score1++; // fire
                    ammo1--;
                }
            } else { // Fire
                if (ammo2 == 0) {
                    if (ammo1 == 0) // reload
                    {
                        ammo1++;
                    }
                    else {
                        score1++; // fire
                        ammo1--;
                    }
                } else { // block
                    ammo2--;
                }
            }
        }
        System.out.println(score1);
    }
}
