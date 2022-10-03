/**
 * @author Bethel Panashe Choto
 *
 */

public class Main {
    public static void main(String[] args) {
        Airport_Info airport = new Airport_Info();
        WriteInFile.takeInputs();
        Airport_Info.readAirport("airports.csv");

        ReadInputs.readInputs("input.csv");
        Routes.readRoutes("routes.csv");
        Search.searchAlgorithm(Airport_Info.getStart(),Airport_Info.getDestination());
    }
}