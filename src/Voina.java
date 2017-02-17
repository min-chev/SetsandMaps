import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        LinkedHashSet<Integer> playerOne = fillSets();
        LinkedHashSet<Integer> playerTwo = fillSets();

        for (int i = 0; i < 50; i++) {

            if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                break;
            }

            int firstNum = playerOne.iterator().next();
            playerOne.remove(firstNum);

            int secondNum = playerTwo.iterator().next();
            playerTwo.remove(secondNum);

            if(firstNum>secondNum){
                playerOne.add(firstNum);
                playerOne.add(secondNum);

            }else if(secondNum>firstNum){
                playerTwo.add(firstNum);
                playerTwo.add(secondNum);
            }
        }
        if (playerOne.size()>playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerOne.size()<playerTwo.size()) {
            System.out.println("Second player win!");
        } else if (playerOne.size()==playerTwo.size()) {
            System.out.println("Draw!");

        }


    }

    private static LinkedHashSet<Integer> fillSets() {
        String[] player = scanner.nextLine().split(" ");

        LinkedHashSet<Integer> linkset = new LinkedHashSet<>();
        for (String s : player) {
            linkset.add(Integer.parseInt(s));
        }

        return linkset;
   }
}
