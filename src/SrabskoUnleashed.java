import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Long>> BigMap = new LinkedHashMap<>();

        String inp = scanner.nextLine();
        while(true){
            if(inp.equals("End")){
                break;
            }

            String regex = "^(?<singer>\\w+(\\s\\w+)*?) @(?<venue>\\w+(\\s\\w+)*?)\\s(?<price>\\d+)\\s(?<count>\\d+)$";
            Pattern pattern1 = Pattern.compile(regex);

            Matcher matcher = pattern1.matcher(inp);
            if (matcher.find()) {
                String event = matcher.group("venue");
                String singer = matcher.group("singer");
                int ticketPrice = Integer.parseInt(matcher.group("price"));
                long ticketsCount = Long.parseLong(matcher.group("count"));

                if (!BigMap.containsKey(event)) {
                    LinkedHashMap<String, Long> smallMap = new LinkedHashMap<>();
                    smallMap.put(singer, ticketsCount * ticketPrice);
                    BigMap.put(event, smallMap);
                } else {
                    LinkedHashMap<String, Long> smallMap = BigMap.get(event);

                    if (!smallMap.containsKey(singer)) {
                        smallMap.put(singer, ticketsCount * ticketPrice);
                    } else {
                        smallMap.put(singer, smallMap.get(singer) + ticketsCount * ticketPrice);
                    }

                    BigMap.put(event, smallMap);
                }
            }


            inp = scanner.nextLine();
        }

        for (String s : BigMap.keySet()) {
            System.out.println(s);
            BigMap.get(s).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry ->
                    System.out.println("#  " + entry.getKey() + " -> " + entry.getValue())
            );
        }

    }
}
