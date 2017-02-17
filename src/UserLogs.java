import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, List<String>>> MainMap = new TreeMap<>();
        while (true) {
            if (inp.equals("end")) {
                break;
            }
            String[] line = inp.split(" ");

            String[] IP = line[0].split("=");
            String[] msg = line[1].split("=");
            String[] user = line[2].split("=");

            if (!MainMap.containsKey(user[1])) {
                LinkedHashMap<String, List<String>> smallMap = new LinkedHashMap<>();
                List<String> smallestMap = new ArrayList<>();
                smallestMap.add(msg[1]);
                smallMap.put(IP[1], smallestMap);
                MainMap.put(user[1], smallMap);
            }else if(MainMap.containsKey(user[1]) && !MainMap.get(user[1]).containsKey(IP[1])){
                LinkedHashMap<String, List<String>> smallMap = MainMap.get(user[1]);
                List<String> smallestMap = new ArrayList<>();
                smallestMap.add(msg[1]);
                smallMap.put(IP[1], smallestMap);
                MainMap.put(user[1], smallMap);
            }
            else if(MainMap.containsKey(user[1]) && MainMap.get(user[1]).containsKey(IP[1])){
                LinkedHashMap<String, List<String>> smallMap = MainMap.get(user[1]);
                List<String> smallestMap = smallMap.get(IP[1]);
                smallestMap.add(msg[1]);
                smallMap.put(IP[1], smallestMap);
                MainMap.put(user[1], smallMap);
            }

            inp = scanner.nextLine();
        }


        for (String s : MainMap.keySet()) {
            System.out.println(s +": ");
            LinkedHashMap<String, List<String>> smallerMap = MainMap.get(s);
            int index = 1;
            for (Map.Entry<String, List<String>> s1 : smallerMap.entrySet()) {
                System.out.print(s1.getKey()+" => ");
                System.out.print(s1.getValue().size());
                if(index < smallerMap.entrySet().size()){
                    System.out.print(", ");
                }else{
                    System.out.println(".");
                }
                index++;
            }
        }
    }
}
