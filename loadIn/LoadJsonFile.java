/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loadIn;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import user.User;

/**
 *
 * @author k1fryouf
 */
public class LoadJsonFile {
    
     public static User load(JsonReader reader) throws IOException {
         
     Double amount = 0.0;
     String description = null;
     int duration = 0;
     int frequencyComposition = 0;
     int paymentFrequency = 0;
     String id = "";
     int interestRates = 0;
     User customer = new User ();
     
     
     

     reader.beginObject();
     
     while (reader.hasNext()) {
         
       String name = reader.nextName();
       
       if (name.equals("amount")) {
         amount = reader.nextDouble();
       } else if (name.equals("description")) {
         description= reader.nextString();
       } else if (name.equals("frequencyComposition")) {
         frequencyComposition = reader.nextInt();
       } else if (name.equals("paymentFrequency")) {
         paymentFrequency = reader.nextInt();
       } else if (name.equals("duration")) {
         duration = reader.nextInt();    
       } else if (name.equals("id")) {
         id = reader.nextString(); 
       } else if (name.equals("interestRates")) {
         interestRates = reader.nextInt();    
       } else {   
         reader.skipValue();
       }
       
     }
       customer.setAmount(amount);
       customer.setDescription(description);
       customer.setDuration(duration);
       customer.setFrequencyComposition(frequencyComposition);
       customer.setId(id);
       customer.setPaymentFrequency(paymentFrequency);
       customer.setInterestRates(interestRates);
     
     
     reader.endObject();
     
     
     return customer;
   }
    
}
