package CCC;

import java.util.*;
import java.util.stream.Collectors;

public class ModeFinding {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> hMap = new HashMap();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        for (int j = 0; j < n; j++) {
            if (hMap.containsKey(input[j])){
                hMap.replace((input[j]), hMap.get(input[j])+1);
            } else
                hMap.put((input[j]), 0);
        }
        Map<String, Integer> sortedMapDesc = sortByValue(hMap, false);
        Set<String> set = sortedMapDesc.keySet();
        Object[] array = set.stream().toArray();
        int num = sortedMapDesc.get(array[0]);
        int smallestNum = Integer.parseInt(String.valueOf(array[0]));
        for (int i = 1; i < array.length; i++) {
            if (sortedMapDesc.get(array[i]) == num){
                int number = Integer.parseInt(String.valueOf(array[i]));
                if (number < smallestNum){
                    smallestNum = number;
                }
            }
        }
        System.out.println(smallestNum);
    }
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }
}
