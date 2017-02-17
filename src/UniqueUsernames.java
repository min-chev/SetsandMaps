import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> treeSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(scanner.nextLine());
        }

        for (String s : treeSet) {
            System.out.println(s);
        }

    }
}
