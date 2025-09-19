package CCC;

import java.util.*;

public class OnlineShopping {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = t; i > 0; i--) {
            int n = scanner.nextInt();
            Map<String, List<item>> map = new HashMap<>();
            for (int j = 1; j <= n; j++) {
                int m = scanner.nextInt();
                scanner.nextLine();
                for (int k = 1; k <= m; k++) {
                    String[] ar = scanner.nextLine().split(" ");
                    if (!map.containsKey(ar[0])) {
                        map.put(ar[0], new ArrayList<>());
                    }
                    map.get(ar[0]).add(new item(Integer.parseInt(ar[1]), Integer.parseInt(ar[2])));
                }
            }
            int k = scanner.nextInt();
            int cost = 0;
            scanner.nextLine();
            for (int j = 1; j <= k; j++) {
                String[] ar = scanner.nextLine().split(" ");
                int need = Integer.parseInt(ar[1]);
                List<item> list = map.get(ar[0]);
                Collections.sort(list);
                for (item e: map.get(ar[0])) {
                    if (e.amount >= need) {
                        cost += e.price * need;
                        need = 0;
                        break;
                    } else {
                        cost += e.price * e.amount;
                        need -= e.amount;
                    }
                }
            }
            System.out.println(cost);
        }
    }
    static class item implements Comparable<item> {
        int price, amount;
        item (int p, int a) {price = p; amount = a;}
        public String toString() {return "price = " + price + " amount=" + amount;}
        public int compareTo(item x) {return Integer.compare(price, x.price);}
    }
}
