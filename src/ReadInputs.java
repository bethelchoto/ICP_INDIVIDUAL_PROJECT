/**
 * @author Bethel Panashe Choto
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadInputs {
    /**Reading inputs from the inputs file
     **/
    public static ArrayList<ArrayList<String>> readInputs(String in) {
        ArrayList<ArrayList<String>> start_destination_Loc = new ArrayList<>();
        String line_input;
        try {
            BufferedReader inputs_line = new BufferedReader(new FileReader(in));
            String line;
            while ((line = inputs_line.readLine()) != null) {
                ArrayList<String> temp_inputs = new ArrayList<>();
                temp_inputs.add(line.split(",")[0].trim());
                temp_inputs.add(line.split(",")[1].trim());
                start_destination_Loc.add(temp_inputs);
            }
            inputs_line.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return start_destination_Loc;
    }
}
