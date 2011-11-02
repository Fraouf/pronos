/*
 * Cette classe contient la méthode qui charge les fichiers Json et elle enregistre 
 * les valeurs obtenues dans des variables.
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
    
     // Cette méthode  prend en paramétres un Objet de type JsonReader et retourne un
     // Objet User.
     // @ JsonReader
    
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
       
       if (name.equals("amount") || name.equals("montant")) {
         amount = reader.nextDouble();
       } else if (name.equals("description") || name.equals("description")) {
         description= reader.nextString();
       } else if (name.equals("frequencyComposition") || name.equals("frequenceComposition")) {
         frequencyComposition = reader.nextInt();
       } else if (name.equals("paymentFrequency") || name.equals("versementPeriodique")) {
         paymentFrequency = reader.nextInt();
       } else if (name.equals("duration") || name.equals("nombreAnnee")) {
         duration = reader.nextInt();    
       } else if (name.equals("id") || name.equals("id")) {
         id = reader.nextString(); 
       } else if (name.equals("interestRates") || name.equals("tauxInteret")) {
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
