import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        int counter = 1;
        String metal = null;
        while (true) {
            if (inp.equals("stop")) {
                break;
            }
            if (counter == 1) {
                metal = inp;
                counter++;
            } else if (counter == 2) {
                if(!linkedHashMap.containsKey(metal)) {
                    linkedHashMap.put(metal, Integer.parseInt(inp));
                }else{
                    linkedHashMap.put(metal, linkedHashMap.get(metal)+ Integer.parseInt(inp));

                }

                counter--;

            }

            inp = scanner.nextLine();
        }



        for (String s : linkedHashMap.keySet()) {
            System.out.println(s + " -> " + linkedHashMap.get(s));
        }


    }
}
