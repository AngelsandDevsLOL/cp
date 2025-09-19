package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class ConspicuousCrypticChecklist {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        HashSet<String> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hSet.add(scanner.nextLine());
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean bool = true;
            int x = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < x; j++) {
                String string = scanner.nextLine();
                if (!hSet.contains(string)) {
                    bool = false;
                }
            }
            if (bool) {
                count++;
            }
        }
        System.out.println(count);
    }
}
