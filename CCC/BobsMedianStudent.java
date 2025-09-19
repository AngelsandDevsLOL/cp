package CCC;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class BobsMedianStudent {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<String, Integer> hmap = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            hmap.put(input[0],Integer.parseInt(input[1]));
        }
        String[] keys= sortByValue(hmap);
        double size = hmap.size()/2;

        for (int i = 0; i < hmap.size(); i++) {
            if (i == Math.ceil(size)){
                System.out.println(keys[i]);
            }
        }
    }
    private static String[] sortByValue(Map<String, Integer> map){
        return map.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new)).keySet().toArray(new String[0]);
    }
}
