/**
 * @author Bethel Panashe Choto
 *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Routes {
    /**Reading airport file
     * return a hashmap of routes that can be accessible from each start position
     * return route
     **/
    public static HashMap<String, ArrayList<String>> readRoutes(String routes){ // List<>
        HashMap<String, ArrayList<String>> route = null;
        try{
            BufferedReader path = new BufferedReader(new FileReader(routes));
            ArrayList<String> code_stops = new ArrayList<>(); //List<>
            route = new HashMap<>();
            String routes_line;
            while((routes_line = path.readLine()) != null){
                String [] route_line = routes_line.split(",");
                String strt_code = route_line[2];// start location
                String dst_code = route_line[4];// destination
                ArrayList<String> temp = new ArrayList<>(); //List<>
                if(route.containsKey(strt_code)){
                    temp = route.get(route_line[2]);
                }
                temp.add(dst_code);
                route.put(strt_code, temp);
            }
            path.close();
        }   catch (FileNotFoundException e){
            System.out.print("Routes File Not Found!");
        }
        catch (IOException e) {
            System.out.print("Error While Reading the file");
        }
        return route;
    }
}
