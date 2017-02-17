import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<String> normalList = new TreeSet<>();
        TreeSet<String> vipList = new TreeSet<>();

        //fill lists
        while (true) {
            String inp = scanner.nextLine();
            if ("PARTY".equals(inp)) {
                break;
            }
            if (Character.isDigit(inp.charAt(0))) {
                vipList.add(inp);

            } else {
                normalList.add(inp);
            }
        }

        while (true) {
            String inp2 = scanner.nextLine();
            if ("END".equals(inp2)) {
                break;
            }
            if (vipList.contains(inp2)) {
                vipList.remove(inp2);
            } else if (normalList.contains(inp2)) {
                normalList.remove(inp2);
            }

        }


        int total = vipList.size() + normalList.size();
        System.out.println(total);
        vipList.forEach(System.out::println);
        normalList.forEach(System.out::println);


    }
}
