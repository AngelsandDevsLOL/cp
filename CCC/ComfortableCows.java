package CCC;

public class ComfortableCows{
    public static void main (String args[]){

    }
}

/*
package CCC2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ComfortableCows {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[][] array = new boolean[1001][1001];
        Set<String> compfortCowSet= new HashSet();
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            array[x1][y1] = true;
            addOrRemove(x1,y1,array,false, compfortCowSet); // add to hashset, first time
            addOrRemove(x1+1,y1,array,compfortCowSet.contains((x1+1)+"-"+y1), compfortCowSet); // down, check if it is in compfortCowSet
            addOrRemove(x1,y1+1,array,compfortCowSet.contains((x1)+"-"+(y1+1)), compfortCowSet);
            if (x1>0) {
                addOrRemove(x1-1,y1,array,compfortCowSet.contains((x1-1)+"-"+y1), compfortCowSet);
            }
            if (y1>0) {
                addOrRemove(x1,y1-1,array,compfortCowSet.contains((x1)+"-"+(y1-1)), compfortCowSet);
            }
            System.out.println(compfortCowSet.size());
        }
    }

    private static void addOrRemove(int x, int y, boolean[][] array,boolean isInCompfortCowSet, Set<String> compfortCowSet) {
        int count=0;
        if (array[x+1][y]) count++;
        if (array[x][y+1]) count++;
        if (x>0 && array[x-1][y]) count++;
        if (y>0 && array[x][y-1]) count++;

        if (count==3 ) {
            if(!isInCompfortCowSet)  compfortCowSet.add(x+"-"+y);
        }else if (isInCompfortCowSet) {
            compfortCowSet.remove(x+"-"+y);
        }
    }

}
*/


/*package CCC2;

import java.util.Scanner;

public class ComfortableCows {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int comfortable = 0;
        boolean[][] array = new boolean[1001][1001];
        for (int i = 0; i < n; i++) {
            comfortable = 0;
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            array[x1][y1] = true;
            for (int k = 0; k < 4; k++) {
                // check to see how many cows turned into comfortable cows
                int x = x1;
                int y = y1;
                if (k == 0){
                    if (x1 != 0){
                        x = x1 - 1;
                    } else
                        continue;
                } else if (k == 1){
                    if (y1 != 1000){
                        y = y1 + 1;
                    } else
                        continue;
                } else if (k == 2){
                    if (x1 != 1000){
                        x = x1 + 1;
                    } else
                        continue;
                } else if (k == 3){
                    if (y1 != 0){
                        y = y1 - 1;
                    } else
                        continue;
                }
                if (array[x][y] == true) { // if it isn't true, there isn't any cow, meaning there is 0 chance of there being a comfortable cow in a place where there is NO COW
                    // find surroundings to see whether this particular cow is COMFORTABLE or not
                    int cows = 0;
                    if (y != 0 && array[x][y - 1] == true) { // left
                        cows++;
                    }
                    if (x != 0 && array[x - 1][y] == true) { // up
                        cows++;
                    }
                    if (y != 1000 && array[x][y + 1] == true) { // right
                        cows++;
                    }
                    if (x != 1000 && array[x + 1][y] == true) { // down
                        cows++;
                    }
                    if (cows == 3) {
                        comfortable++;
                    } else if (cows == 4){
                        comfortable--;
                    }
                }
            }
            System.out.println(comfortable);
        }
    }
}
*/