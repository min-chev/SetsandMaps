import java.lang.reflect.Array;
import java.util.*;

public class HandsofCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        LinkedHashMap<String, HashSet<String>> Map = new LinkedHashMap<>();
        while (true) {
            if (inp.equals("JOKER")) {
                break;
            }
            String[] input = inp.split(": ");
            String[] cards = input[1].split(", ");
            if (!Map.containsKey(input[0])) {
                HashSet<String> currentSet = new HashSet<>();
                currentSet.addAll(Arrays.asList(cards));
                currentSet.removeAll(Arrays.asList("", " "));
                Map.put(input[0], currentSet);
            } else {
                HashSet<String> currentSet = Map.get(input[0]);
                currentSet.addAll(Arrays.asList(cards));
                currentSet.removeAll(Arrays.asList("", " "));
                Map.put(input[0], currentSet);
            }

            inp = scanner.nextLine();
        }

        for (String s : Map.keySet()) {
            int result = 0;
            for (String s1 : Map.get(s)) {
                int power = 0;
                int multiplier = 0;
                String partOne;
                String partTwo;

                if (Character.isDigit(s1.charAt(1))) {
                    partTwo = s1.substring(2, 3);
                    power = Integer.parseInt(s1.substring(0, 2));
                } else {
                    partOne = s1.substring(0, 1);
                    partTwo = s1.substring(1, 2);

                    if (Character.isDigit(partOne.charAt(0))) {
                        power = Integer.parseInt(partOne);
                    } else {

                        switch (partOne) {
                            case "J":
                                power = 11;
                                break;
                            case "Q":
                                power = 12;
                                break;
                            case "K":
                                power = 13;
                                break;
                            case "A":
                                power = 14;
                                break;
                        }
                    }
                }
                switch (partTwo) {
                    case "S":
                        multiplier = 4;
                        break;
                    case "H":
                        multiplier = 3;
                        break;
                    case "D":
                        multiplier = 2;
                        break;
                    case "C":
                        multiplier = 1;
                        break;
                }
                result += multiplier * power;
            }
            HashSet<String> currentSet = new HashSet<>();
            currentSet.add(String.valueOf(result));
            Map.put(s, currentSet);
        }

        for (String s : Map.keySet()) {
            System.out.print(s + ": ");
            Map.get(s).forEach(System.out::println);
        }
    }
}
