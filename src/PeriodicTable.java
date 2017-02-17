import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        TreeMap<Character, Integer> treeSet = new TreeMap<>();
        for (Character s : line.toCharArray()) {
            if(treeSet.containsKey(s)){
                treeSet.put(s, treeSet.get(s)+1);
            }
            else{
                treeSet.put(s, 1);
            }
        }

        for (Character s : treeSet.keySet()) {
            System.out.println(s + ": " + treeSet.get(s) + " time/s");
        }



    }
}
