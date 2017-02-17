

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());

        TreeMap<String, TreeMap<String, Integer>> BigMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String user = input[1];
            String ip = input[0];
            Integer time = Integer.parseInt(input[2]);

            if (!BigMap.containsKey(user)) {
                TreeMap<String, Integer> smallMap = new TreeMap<>();
                smallMap.put(ip, time);
                BigMap.put(user, smallMap);

            } else {
                TreeMap<String, Integer> smallMap = BigMap.get(user);
                if (!smallMap.containsKey(ip)) {
                    smallMap.put(ip, time);
                } else {
                    smallMap.put(ip, smallMap.get(ip) + time);
                }
                BigMap.put(user, smallMap);

            }
        }


        for (String s : BigMap.keySet()) {
            Long time = 0L;
            TreeMap<String, Integer> smallMap = BigMap.get(s);

            for (Map.Entry<String, Integer> stringIntegerEntry : smallMap.entrySet()) {
                time += stringIntegerEntry.getValue();
            }
            System.out.print(s + ": "+ time + " [");

            ArrayList<String> list = new ArrayList<>();
            for (Map.Entry<String, Integer> stringIntegerEntry : smallMap.entrySet()) {
               list.add(stringIntegerEntry.getKey());
            }
            System.out.print(String.join(", ", list));

            System.out.println(']');


        }
    }

}
