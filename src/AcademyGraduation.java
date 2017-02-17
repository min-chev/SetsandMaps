import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Double> treemap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] scoresInp = scanner.nextLine().split(" ");

            Double scoressum = 0.00;
            for (String aScoresInp : scoresInp) {
                scoressum += Double.parseDouble(aScoresInp);
            }

            scoressum = scoressum/scoresInp.length;

            treemap.put(name, scoressum);

        }

        for (String string : treemap.keySet()) {
            System.out.print(string +" is graduated with ");
            System.out.println(treemap.get(string));
        }
    }
}
