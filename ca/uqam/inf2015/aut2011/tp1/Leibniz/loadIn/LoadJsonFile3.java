/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loadIn;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import user.User;
import user.User2;

/**
 *
 * @author k1fryouf
 */
public class LoadJsonFile3 {
    
     public static User2 load(JsonReader reader) throws IOException {
         
     long amount = 0;
     String description = null;
     int duration = 0;
     int frequencyComposition = 0;
     int paymentFrequency = 0;
     String id = "";
     int interestRates = 0;
     User2 customer = new User2 ();
     
     
     

     reader.beginObject();
     
     while (reader.hasNext()) {
         
       String name = reader.nextName();
       
       if (name.equals("amount")) {
         amount = reader.nextLong();
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
