package CCC;

import java.util.*;

public class GoingBackToTheDefinitions {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aList.add(scanner.nextLine());
        }
        Collections.sort(aList, new cmp());
        for (String i : aList) {
            System.out.print(i);
        }
    }
    static class cmp implements Comparator<String> {
        public int compare(String a, String b) {
            return -(a+b).compareTo(b+a);
        }
    }
}
