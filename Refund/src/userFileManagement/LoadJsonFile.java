/*
 * Cette classe contient la méthode qui charge les fichiers Json et elle enregistre 
 * les valeurs obtenues dans des variables.
 */
package userFileManagement;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import user.Reclamation;
import user.Remboursement;
import user.User;
import utils.Montant;
import utils.Validation;

/**
 *
 * @author k1fryouf
 */
public class LoadJsonFile {

    public static List<Remboursement> listRemb = new ArrayList<>();
    // Cette méthode  prend en paramétres un Objet de type JsonReader et retourne un
    // Objet User.
    // @ JsonReader
    public static User load(JsonReader reader) throws IOException {

        String client = "";
        char contrat = 'z';
        String mois = "";
        List<Reclamation> listReclam = new ArrayList<>();
        User customer = new User();

        reader.beginObject();

        while (reader.hasNext()) {

            String name = reader.nextName();

            switch (name) {
                case "client":
                    client = reader.nextString();
                    break;
                case "contrat":
                    contrat = reader.nextString().charAt(0);
                    break;
                case "mois":
                    mois = reader.nextString();
                    break;
                case "reclamations":
                    listReclam = readArray(reader);
                    break;
                default:
                    reader.skipValue();
                    break;
            }

        }
        customer.setClient(client);
        customer.setContrat(contrat);
        customer.setMois(mois);
        customer.setListReclam(listReclam);
        customer.setListRemb(listRemb);

        reader.endObject();
        
        try{
            
            if(Validation.validerClient(customer)){
                return customer;
            }else{
                return null;
            }
            
        }catch(Exception e){
            
            return null;
        }
    }
    
     public static List<Reclamation> readArray(JsonReader reader) throws IOException {
     List<Reclamation> listReclam = new ArrayList();

     reader.beginArray();
     while (reader.hasNext()) {
       listReclam.add(readReclam(reader));
     }
     reader.endArray();
     return listReclam;
   }
     
     public static Reclamation readReclam(JsonReader reader) throws IOException{
         
        int soin = -1;
        String date = "";
        double montant = 0;
        
        reader.beginObject();

        while (reader.hasNext()) {

            String name = reader.nextName();

            switch (name) {
                case "soin":
                    soin = reader.nextInt();
                    break;
                case "date":
                    date = reader.nextString();
                    break;
                case "montant":
                    montant = Montant.lireMontant(reader.nextString());
                    break;
                default:
                    reader.skipValue();
                    break;
            }

        }  

        reader.endObject();
        
        listRemb.add(new Remboursement(soin,date,""));
        
        return new Reclamation(soin, date, Montant.ecrireMontant(montant));
        
     }


}
