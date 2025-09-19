package CCC;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class CommonWords {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            int words = scanner.nextInt();
            int common = scanner.nextInt();
            HashMap<String, Integer> hMap = new HashMap<>();
            scanner.nextLine();
            for (int j = 0; j < words; j++) {
                String input = scanner.nextLine();
                if (hMap.containsKey(input)){
                    hMap.replace(input, hMap.get(input)+1);
                } else
                    hMap.put(input, 0);
            }
            Map<String, Integer> sortedMapDesc = sortByValue(hMap, false);
            Set<String> set = sortedMapDesc.keySet();
            Object[] array = set.stream().toArray();
            System.out.println(array[common-1]);
        }
    }
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }
}
