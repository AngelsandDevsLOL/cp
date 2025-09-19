package Random;

import java.util.Scanner;

public class TheresAnEssayInMyCode {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String s = scanner.nextLine();
            String ans = "";
            for (int j = 0; j < s.length(); j++) {
                if (s.substring(j,j+1).equals("\"")) {
                    int nxt = s.indexOf("\"", j + 1);
                    ans += " " + s.substring(j + 1, nxt);
                    j = nxt;
                } else if (s.substring(j,j+1).equals("\'")) {
                    int nxt = s.indexOf("\'", j+1);
                    ans += " " + s.substring(j+1, nxt);
                    j = nxt;
                } else if (j+2 <= s.length() && s.substring(j,j+2).equals("/*")) {
                    int nxt = s.indexOf("*/", j + 2);
                    ans += " " + s.substring(j+2, nxt);
                    j = nxt + 1;
                } else if (j+2 <= s.length() && s.substring(j,j+2).equals("//")) {
                    ans += " " + s.substring(j+2);
                    j = s.length();
                }
            }
            if (ans.length() > 0) {
                System.out.println(ans.substring(1));
            }
        }
    }
}
