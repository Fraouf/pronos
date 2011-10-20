
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import loadIn.LoadJsonFile;
import loadIn.LoadJsonFile3;
import saveIn.SaveJsonFile;
import saveIn.SaveJsonFile3;
import user.Calculate;
import user.Calculate2;
import user.User;
import user.User2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k1fryouf
 */
public class Application2 {
    

	public static void main (String[]args){
            
            
            String fileName = "test2.json";
            
            
            
            try{
                
                JsonReader  file = new JsonReader( new FileReader("src/intrant/"+fileName));

		User2 customer = new User2();
                
                customer = LoadJsonFile3.load(file);
                
                Calculate2.calculateTotalPayment(customer);

                SaveJsonFile3.save(customer);


            }catch (IOException e){
            
		System.out.println (e);
		//System.out.println (customer.getDescription());
		//System.out.println (customer.getAmount());
		//System.out.println (customer.getDuration());
		//System.out.println (customer.getPaymentFrequency());
		//System.out.println (customer.getInterestRates());
		//System.out.println (customer.getFrequencyComposition());
            }

	}
}


    

