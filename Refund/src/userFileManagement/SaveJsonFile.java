/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userFileManagement;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import user.User;

/**
 *
 * @author k1fryouf
 */
public class SaveJsonFile {

    private static final String chemin = "/Users/k1fryouf/NetBeansProjects/Refund/src/extrant/";

    public static void save(User customer, String fileName) {

        Gson gson = new Gson();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(customer);

        json = json.replace("{", "{\n");
        json = json.replace("}", "\n}");
        json = json.replace("[", "[\n");
        json = json.replace("]", "\n]\n");
        json = json.replace(",", ",\n");

        //write converted json data to a file named "file.json"
        System.out.println("Execution terminé");
        try (FileWriter writer = new FileWriter(chemin + fileName)) {
            writer.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
