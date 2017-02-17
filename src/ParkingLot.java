import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        HashSet<String> parkingSet = new HashSet<>();
        while (!inp.equals("END")) {
            String[] row = inp.split(", ");

            if (row[0].equals("IN")) {
                parkingSet.add(row[1]);

            } else if (row[0].equals("OUT")) {
                parkingSet.remove(row[1]);
            }
            inp = scanner.nextLine();
        }

        if(parkingSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        for (String s : parkingSet) {
            System.out.println(s);
        }

    }
}
