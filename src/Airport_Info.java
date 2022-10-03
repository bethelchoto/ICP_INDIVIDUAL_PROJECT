/**
 * @author Bethel Panashe Choto
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Airport_Info {
    public static HashMap<ArrayList<String>, String> countries = new HashMap<>();
    static ArrayList<String> start_Location = new ArrayList<>();
    static ArrayList<String> destination = new ArrayList<>();
    public static String start_dest_string;

    /**read airport data
     * returns String start_final_Destination
     **/
    public static String readAirport(String airports){
        BufferedReader line_airport;
        try {
            line_airport = new BufferedReader(new FileReader(airports));
            String temp_airport;
            while ((temp_airport = line_airport.readLine()) != null) {
                ArrayList<String> city_country = new ArrayList<>();
                String[] arr_countries = temp_airport.split(",");
                city_country.add(arr_countries[2]); // city
                city_country.add(arr_countries[3]);//country
                //city_country.add(arr_countries[5]); airline code
                countries.put(city_country, arr_countries[4]);
            }
            line_airport.close();
            String start_city;
            if (countries.containsKey(StartLoc())) {
                start_city = countries.get(StartLoc());
            }
            String dest_city;
            if(countries.containsKey(Destination())){
                dest_city = countries.get(Destination());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        start_dest_string = countries.get(StartLoc()) +","+countries.get(Destination());
        return start_dest_string;
    }
    /**
     * returns the start_location
     * @return start_location
     */
    public static ArrayList<String> StartLoc(){
        start_Location = ReadInputs.readInputs("input.csv").get(0);

        return start_Location;
    }
    /**
     * returns the arraylist of the destination
     * @return destination
     *
     */
    public static ArrayList<String> Destination(){
        destination = ReadInputs.readInputs("input.csv").get(1);
        return destination;
    }
    /**
     * returns the String start location
     * @return start_location
     *
     */
    public static String getStart(){ // val --> returned from the
        return start_dest_string.split(",")[0];
    }
    /**
     * returns the string of the destination
     * @return destination
     *
     */
    public static String getDestination(){ // val --> returned from the
        return start_dest_string.split(",")[1];
    }
}
