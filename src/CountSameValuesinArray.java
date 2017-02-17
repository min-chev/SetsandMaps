import java.util.*;

public class CountSameValuesinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String anInput : input) {
            if (!map.containsKey(anInput)) {
                map.put(anInput, 1);
            } else if (map.containsKey(anInput)) {
                map.put(anInput, map.get(anInput) + 1);
            }
        }


        for (Map.Entry<String, Integer> aDouble : map.entrySet()) {
            System.out.print(aDouble.getKey());
            System.out.println(" - " + aDouble.getValue() + " times");
        }


    }
}

