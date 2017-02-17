import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inp = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> MainMap = new LinkedHashMap<>();

        while (true) {
            if (inp.equals("report")) {
                break;
            }

            String[] line = inp.split("\\|");

            String city = line[0];
            String country = line[1];
            Long population = Long.parseLong(line[2]);


            if(!MainMap.containsKey(country)){
                LinkedHashMap<String, Long> smallMap = new LinkedHashMap<>();
                smallMap.put(city, population);
                MainMap.put(country, smallMap);
            }
            else if(MainMap.containsKey(country)){
                LinkedHashMap<String, Long> smallMap = MainMap.get(country);
                smallMap.put(city, population);
                MainMap.put(country, smallMap);
            }

            inp = scanner.nextLine();
        }

        Map<String, Long> countriesByPopulation = new LinkedHashMap<>();

        for (String country : MainMap.keySet()) {
            long totalPopulation = 0;
            for (Long populationCount : MainMap.get(country).values()) {
                totalPopulation += populationCount;
            }
            countriesByPopulation.put(country, totalPopulation);
        }

        countriesByPopulation.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " (total population: " + entry.getValue() + ")");
                    MainMap.get(entry.getKey()).entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .forEach(pair -> {
                                System.out.println("=>" + pair.getKey() + ": " + pair.getValue());
                            });
                });
    }
}
