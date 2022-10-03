/**
 * @author Bethel Panashe Choto
 *
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Node {
    /**
     * Instance Variables/Fields
     */

    public static String start_city;
    public static String destination;
    String state;
    Node parent;
    int stops;

    /**
     * Constructor:
     * Build and initialise objects of this class
     * @param state the name of the current state of the node
     * @param parent the parent of the current ndoe
     */
    public Node(String state, Node parent, Integer stops){
        this.state = state;
        this.parent = parent;
    }
    /**
     * returns the true if the destination is found from the start location
     * @return boolean
     *
     */
    public static boolean goal_test(String start, String destination){
        if(start.equals(destination)) {
            return true;
        }
        return false;
    }
    public static void succ_routes(){
    }
    public static ArrayList<String> actions(String airportCode){
        if (Routes.readRoutes("routes.csv").containsKey(airportCode)){
            return (Routes.readRoutes("routes.csv").get(airportCode));
        };// return a hashmap --> routes
        return (Routes.readRoutes("routes.csv").get(airportCode));
    }
    /**
     * returns routes path
     * @return routes path
     *
     */
    public static ArrayList<Node> solution_path(Node code) {
        //implement the solution path leading to this node
        ArrayList<Node> routes_path = new ArrayList<>();
        int overrall_stops = 0;
        ArrayList<Node> sequence_of_action = new ArrayList<>();
        while(code.parent != null){
            routes_path.add(0, code);
            overrall_stops+=1;
            code = code.parent;
        }
        writeTofile(routes_path);
        return routes_path;
    }
    /**
     * writes to the file the solution
     *
     */
    public static void writeTofile(ArrayList<Node> print_void){ // must write to the file
        int count = 0;
        int stops = 0;
        PrintWriter file_write = null;
        try {
            file_write = new PrintWriter(new FileOutputStream("output.csv"));
            while (count < print_void.size()) {
                file_write.println((count + 1) + "." + " " + print_void.get(count).state + " From " + print_void.get(count).parent.state + " To " + print_void.get(count).state + " " + stops + " " + "stops");
                count++;
            }
            file_write.println("Total Flights: " + count);
            file_write.println("Total additional stops: " + stops);
            file_write.println("Optimality Criteria: flights");
            file_write.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString(){
        return this.parent.state + " " + this.state;
    }
}
