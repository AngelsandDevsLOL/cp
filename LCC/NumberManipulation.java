package LCC;

import java.util.HashSet;

public class NumberManipulation{
    public static HashSet<String> ans = new HashSet<>();
    public static void main (String[] args) {
        create("", new boolean[15], new String[]{"W","E","D","D","I","N","G","C","A","R","R","I","A","G","E"});
        System.out.println(ans.size());
        System.out.println(ans.contains("WEDDINGCARRIAGE"));
    }
    public static void create (String cur, boolean[] bool, String[] ar) {
        if (cur.length() == ar.length) {
            boolean pray = false;
            for (int i = 1; i < cur.length(); i++) {
                if (cur.charAt(i) == 'G' && cur.charAt(i - 1) == 'I') {pray = true;break;}
                if (cur.charAt(i) == 'I' && cur.charAt(i - 1) == 'G') {pray = true;break;}
            }
            if (pray) {ans.add(cur);}
            return;
        }
        for (int i = 0; i < ar.length; i++) {
            if (!bool[i]) {
                bool[i] = true;
                create(cur + ar[i], bool, ar);
                bool[i] = false;
            }
        }
    }
}