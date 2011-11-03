/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package saveIn;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;
import user.User;

/**
 *
 * @author k1fryouf
 */
public class SaveJsonFile2 {
    
    public static void save(User customer) {
	Gson gson = new Gson();
 
	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(customer);
 
	try {
		//write converted json data to a file named "file.json"
	JsonWriter writer = new JsonWriter(new FileWriter("src/extrant/test1.json"));
        
	   writer.beginObject();   
           writer.name("id");
           writer.value(customer.getId());
           writer.name("description");
           writer.value(customer.getDescription());
           writer.name("amount");
           writer.value(customer.getAmount());
           writer.name("duration");
           writer.value(customer.getDuration());
           writer.name("paymentFrequency");
           writer.value(customer.getPaymentFrequency());
           writer.name("interestRates");
           writer.value(customer.getInterestRates());
           writer.name("totalPayment");
           writer.value(customer.getTotalPayment());
          

        // writer.name("NAME");
        // writer.value("Hello, World!");

        writer.endObject();
        
        
         
        // writer.beginObject();    
        // writer.name("NAME2");
        // writer.value("Hello, World!");
        // writer.endObject();
                
	writer.close();
                
 
	} catch (IOException e) {
		e.printStackTrace();
	}

    }
}


