import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> Precious = new TreeMap<>();
        TreeMap<String, Integer> Trash = new TreeMap<>();

        Precious.put("shards", 0);
        Precious.put("fragments", 0);
        Precious.put("motes", 0);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < line.length - 1; i += 2) {
                if (line[i + 1].equals("shards") || line[i + 1].equals("fragments") || line[i + 1].equals("motes")) {
                    Precious.put(line[i + 1], Precious.get(line[i + 1]) + Integer.parseInt(line[i]));
                } else {
                    if (!Trash.containsKey(line[i + 1])) {
                        Trash.put(line[i + 1], Integer.parseInt(line[i]));
                    } else if (Trash.containsKey(line[i + 1])) {
                        Trash.put(line[i + 1], Trash.get(line[i + 1]) + Integer.parseInt(line[i]));
                    }
                }


                for (String s : Precious.keySet()) {
                    if (Precious.get(s) >= 250) {
                        Precious.put(s, Precious.get(s) - 250);
                        String item = null;
                        if (s.equals("shards")) {
                            item = "Shadowmourne";
                        } else if (s.equals("fragments")) {
                            item = "Valanyr";
                        } else if (s.equals("motes")) {
                            item = "Dragonwrath";
                        }
                        System.out.println(item + " obtained!");

                        Precious.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry ->
                                System.out.println(entry.getKey() + ": " + entry.getValue()
                                ));


                        for (String s1 : Trash.keySet()) {
                            System.out.println(s1 + ": " + Trash.get(s1));
                        }
                        return;
                    }
                }


            }
        }


    }
}
