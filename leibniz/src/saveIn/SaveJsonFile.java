/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saveIn;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import user.User;

/**
 *
 * @author k1fryouf
 */
public class SaveJsonFile {
    
    public static void save(User customer) {
    	
        
	Gson gson = new Gson();
 
	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(customer);
 
	try {
		//write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter("src/extrant/test1.json");
		writer.write(json);
		writer.close();
 
	} catch (IOException e) {
		e.printStackTrace();
	}

    }
}


