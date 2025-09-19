package CCC.Senior;

import java.util.Scanner;
import java.util.TreeSet;

public class Gates {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();
        TreeSet<Integer> tSet = new TreeSet<Integer>();
        for(int x = 1; x <= g; x++)
            tSet.add(x);
        int ans = 0;
        for(int i = 0; i < p; i++){
            int max = sc.nextInt();
            if (tSet.floor(max) == null)
                break;
            tSet.remove(tSet.floor(max));
            ans++;
        }
        System.out.println(ans);
    }
}
