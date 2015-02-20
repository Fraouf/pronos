/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author k1fryouf
 */
public class Erreur {
    
    private static final String chemin = "/Users/k1fryouf/NetBeansProjects/Refund/src/extrant/"; 
    
    public static void messageErreur(Message message, String patchOfJsonFile) {
        
         
        Gson gson = new Gson();
 
        // convert java object to JSON format,
        // and returned as JSON formatted string
        
        String json = gson.toJson(message);
 
        json = json.replace("{","{\n");
        json = json.replace("}","\n}");
        json = json.replace("[","[\n");
        json = json.replace("]","\n]\n");
        json = json.replace(",",",\n");
 
        try {
            //write converted json data to a file named "file.json"
            System.out.println("Le programme a été interrompu !");
            FileWriter writer = new FileWriter(chemin+patchOfJsonFile);
            writer.write(json);
            writer.close();
            
            System.exit(0);
 
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
