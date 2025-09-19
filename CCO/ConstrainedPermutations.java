package CCO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class ConstrainedPermutations {
    static int count;
    static void printPermutn(String str, String ans, TreeMap<String, ArrayList<String>> tMap)
    {

        if (str.length() == 0) {
            boolean bool = true;
            for (String key: tMap.keySet()) {
                int index = ans.indexOf(key);
                ArrayList<String> aList = tMap.get(key);
                for (int i = 0; i < aList.size(); i++) {
                    String value = aList.get(i);
                    int index2 = ans.indexOf(value);
                    if (index > index2) {
                        bool = false;
                        break;
                    }
                }
            }
            if (bool) {
                count++;
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            printPermutn(ros, ans + ch, tMap);
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String s = "";
        for (int i = 1; i <= x; i++) {
            s = s + String.valueOf(i);
        }
        TreeMap<String, ArrayList<String>> tMap = new TreeMap();
        int constraints = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < constraints; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (tMap.containsKey(input[0])) {
                tMap.get(input[0]).add(input[1]);
            } else {
                ArrayList<String> aList = new ArrayList<>();
                aList.add(input[1]);
                tMap.put(input[0], aList);
            }
        }
        printPermutn(s, "", tMap);
        System.out.println(count);
    }
}