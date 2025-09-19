package Random;

import java.util.*;

public class CyclopianPuzzle {
    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 0)
        {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.print(from_rod);
        System.out.println(to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void  main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}