package DMOPC;

import java.util.*;

public class FoldingClothes {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> l1 = new LinkedList();
        for (int i = 0; i < n; i++) {
            l1.add(scanner.nextInt());
        }
        ArrayList<Integer> moves = new ArrayList();
        Collections.reverse(l1);
        LinkedList<Integer> l2 = (LinkedList<Integer>) l1.clone();
        Collections.sort(l2);
        Collections.reverse(l2);
        int x = 0;
        while (x < n) {
            while (x < n && l1.get(x) != l2.get(x)) {
                List<Integer> aList = l1.subList(x, n);
                List<Integer> aList2 = l1.subList(x, n);
                Collections.sort(aList2);
                int num = aList2.get(aList2.size()-1);
                int index = aList.indexOf(num);
                moves.add(aList.size()-index);
                moves.add(n - x - aList.size() + index);
                moves.add(-n+x);
                l1.remove(index+n-aList.size());
                l1.add(x, num);
                x++;
            }
            x++;
        }
        System.out.println(moves.size());
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(moves.get(i));
        }
    }
}
