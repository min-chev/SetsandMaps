import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        HashMap<String, String> phoneBook = new HashMap<>();
        while (true){
            if(inp.equals("search")){
                break;
            }

            String[] contact = inp.split("-");

            phoneBook.put(contact[0], contact[1]);

                 inp = scanner.nextLine();
        }


        String inp2 = scanner.nextLine();
        while (true){
            if(inp2.equals("stop")){
                break;
            }

            if(phoneBook.containsKey(inp2)){
                System.out.println(inp2 + " -> " + phoneBook.get(inp2));
            }else{
                System.out.printf("Contact %s does not exist.\n", inp2);
            }
            inp2 = scanner.nextLine();
        }

    }

}
