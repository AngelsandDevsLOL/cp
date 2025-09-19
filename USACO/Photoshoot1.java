package USACO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Photoshoot1 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char [] s = scanner.nextLine().toCharArray();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < s.length; i+=2) {
            if (s[i] == s[i+1]) continue;
            if (s[i] == 'G' && s[i+1] == 'H') a.add(1);
            else a.add(0);
        }
        int ans = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i-1) != a.get(i)) ans++;
        }
        if (a.size() > 0 && a.get(a.size()-1) == 1) ans++;
        System.out.println(ans);
    }
}
