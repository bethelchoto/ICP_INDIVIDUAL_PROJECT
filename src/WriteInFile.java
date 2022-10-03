/**
 * @author Bethel Panashe Choto
 *
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteInFile {
    /**
     * take inputs for start and final destination and
     * write to a file
     *
     */
    public static void takeInputs(){
        PrintWriter inputs_take = null;
        try{
            inputs_take = new PrintWriter(new FileOutputStream("input.csv"));

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(0);
        }
        inputs_take.println("Accra, Ghana");
        inputs_take.println("Winnipeg, Canada");
        inputs_take.close();
    }
}
