package YetAnotherContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Snap {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> josh = new ArrayList<>();
        ArrayList<Integer> nils = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            josh.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            nils.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            if (josh.get(i) == nils.get(i)) {
                count = i;
                break;
            }
        }
        List<Integer> josh2 = josh.subList(count, josh.size());
        for (int i = 0; i < count; i++) {
            josh2.add(josh.get(i));
        }
        List<Integer> nils2 = nils.subList(count, josh.size());
        for (int i = 0; i < count; i++) {
            nils2.add(nils.get(i));
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (josh2.get(i) == nils2.get(i)) count++;
        }
        System.out.println(count);
    }
}
