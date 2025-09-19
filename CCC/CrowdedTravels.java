package CCC;

import java.util.*;

public class CrowdedTravels {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        ArrayList<Integer> aList = new ArrayList();
        HashMap<Integer, Map<Integer, Integer>> hMap = new HashMap();
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (hMap.containsKey(a)){
                hMap.get(a).put(b, c);
            } else {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(b, c);
                hMap.put(a, map);
            }
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int area = scanner.nextInt();
            if (a == 1) {
                aList.add(area);
            } else {
                for (int j = 0; j < hMap.get(a).size(); j++) {
                    int counting = 0;
                    Map<Integer, Integer> map = new HashMap();
                    map = hMap.get(area);
                    Set<Integer> array = map.keySet();
                    boolean bool = false;
                    int integer = map.get(array);
                    while (bool){
                        integer = map.get(integer);
                        counting = counting + hMap.get(j).get(array);
                        if (integer == 1){
                            bool = true;
                        }
                    }
                    if (counting < count){
                        count = counting;
                    }
                }
            }
        }
    }
}
