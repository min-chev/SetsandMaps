import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, TreeMap<String, ArrayList<Long>>> BigMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            Long health = 250L;
            Long damage = 45L;
            Long armor = 10L;

            if (!input[2].equals("null")) {
                damage = Long.parseLong(input[2]);
            }
            if (!input[3].equals("null")) {
                health = Long.parseLong(input[3]);
            }
            if (!input[4].equals("null")) {
                armor = Long.parseLong(input[4]);
            }

            if (!BigMap.containsKey(type)) {
                ArrayList<Long> smallestSet = new ArrayList<>();
                smallestSet.add(damage);
                smallestSet.add(health);
                smallestSet.add(armor);
                TreeMap<String, ArrayList<Long>> smallMap = new TreeMap<>();
                smallMap.put(name, smallestSet);
                BigMap.put(type, smallMap);
            } else {
                TreeMap<String, ArrayList<Long>> smallMap = BigMap.get(type);
                ArrayList<Long> smallestSet = new ArrayList<>();
                if (smallMap.containsKey(name)) {
                   smallMap.get(name).clear();
                }
                smallestSet.add(damage);
                smallestSet.add(health);
                smallestSet.add(armor);
                smallMap.put(name, smallestSet);
                BigMap.put(type, smallMap);
            }

        }

        //printer
        for (String s : BigMap.keySet()) {
            System.out.print(s + "::(");
            TreeMap<String, ArrayList<Long>> smallMap = BigMap.get(s);
            Double dmgAvg = 0.00;
            Double healthAvg = 0.00;
            Double armorAvg = 0.00;
            ArrayList<String> output = new ArrayList<>();
            for (String s1 : smallMap.keySet()) {
                ArrayList<Long> smallestSet = smallMap.get(s1);
                Integer counter = 1;
                for (Long integer : smallestSet) {
                    if (counter == 1) {
                        dmgAvg += integer;
                    } else if (counter == 2) {
                        healthAvg += integer;
                    } else {
                        armorAvg += integer;
                    }
                    counter++;
                }
            }
            dmgAvg = dmgAvg / smallMap.size();
            healthAvg = healthAvg/smallMap.size();
            armorAvg = armorAvg /smallMap.size();
            output.add(String.format("%.2f",dmgAvg));
            output.add(String.format("%.2f",healthAvg));
            output.add(String.format("%.2f",armorAvg));
            System.out.print(String.join("/", output));
            System.out.println(")");

            for (String s1 : smallMap.keySet()) {
                System.out.print("-" + s1 + " -> ");
                ArrayList<Long> smallestSet = smallMap.get(s1);
                ArrayList<String> output2 = new ArrayList<>();
                int counter = 1;
                for (Long integer : smallestSet) {
                    if (counter == 1) {
                        output2.add("damage: " + integer);
                    } else if (counter == 2) {
                        output2.add("health: " + integer);
                    } else {
                        output2.add("armor: " + integer);
                    }
                    counter++;
                }
                System.out.println(String.join(", ", output2));
            }
        }

    }
}
