import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string = scanner.nextLine().split("");

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String aString : string) {
            if (treeMap.containsKey(aString)) {
                treeMap.put(aString, treeMap.get(aString) + 1);
            } else

                treeMap.put(aString, 1);
        }

        for (String s : treeMap.keySet()) {
            System.out.println(s + " : " + treeMap.get(s) + " time/s");
        }


    }
}
