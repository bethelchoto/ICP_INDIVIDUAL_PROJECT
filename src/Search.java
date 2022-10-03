/**
 * @author Bethel Panashe Choto
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
public class Search {
    /**Using the Breadth first search algorithm to search for all successor
     *nodes to get the path from the start location to the destination location
     **/
    public static ArrayList<Node> searchAlgorithm(String start_city, String destination){
        Node node = new Node(start_city, null, 0);
        if(Node.goal_test(node.state, destination)){
            return Node.solution_path(node);
        }
        ArrayList<Node> frontier = new ArrayList<>();
        HashSet<Node> explored = new HashSet<Node>();
        frontier.add(node);
        while(frontier.size() > 0){
            //
            Node removed_node = frontier.remove(0);
            //System.out.println("Popped Node " + removed_node);
            explored.add(removed_node);
            ArrayList<String> succ_routes = Node.actions(removed_node.state);

            for (String succ_route : succ_routes) {
                Node child_node = new Node(succ_route, removed_node, 0);
                if (!(explored.contains(child_node) && frontier.contains(child_node))) {
                    if (Node.goal_test(child_node.state, destination)) {
                        System.out.println("Solution Found Printing to the file");
                        return Node.solution_path(child_node);
                    }
                }
                    frontier.add(child_node);
                }
            }
        return null;
    }
}
