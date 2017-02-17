import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        int counter = 1;
        String  name = null;
        while (true) {
            if (inp.equals("stop")) {
                break;
            }
            if(counter==1){
                name = inp;
                counter++;

            }else if(counter==2) {
                if (!inp.endsWith(".us") && !inp.endsWith(".uk") && !inp.endsWith(".com")) {
                        emails.put(name, inp);

                }
                counter--;
            }
            inp = scanner.nextLine();
        }

        for (String s : emails.keySet()) {
            System.out.println(s + " -> " + emails.get(s));
        }

    }
}
