import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lengths = scanner.nextLine().split(" ");
        long n = Long.parseLong(lengths[0]);
        long m = Long.parseLong(lengths[1]);

        LinkedHashSet<Long>  linkedsetOne = new LinkedHashSet<>();
        LinkedHashSet<Long> linkedsetTwo = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
           long num =  Long.parseLong(scanner.nextLine());
            linkedsetOne.add(num);
        }

        for (int i = 0; i < m; i++) {
            long num =  Long.parseLong(scanner.nextLine());
                     linkedsetTwo.add(num);

        }

        for (Long Long : linkedsetOne) {
            if(linkedsetTwo.contains(Long)){
                System.out.print(Long + " ");
            }
        }


    }
}
