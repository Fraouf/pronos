package scanFolder;
import java.io.File;
/**
 * Classe servant pour la recherche des fichiés à l intérieur du dossier source.
 * 
 * @author (Mathieu Green) 
 * @version (20/10/2011)
 */
public class ScanningFolder
{
    //récupération du path pour la recherche des fichiés
    //la méthode renvoie un tableau de string contenant les fichiée dans la classe intant
    public static String[] scanningFolderPatch (String path){
    
    //recherche du repertoire
    File repertoire = new File(path);
    //lecture du repertoire
    File jsonFolder[] = repertoire.listFiles();
    //creation de la liste des noms de fichier
    String nameOfJsonFiles[] = new String [jsonFolder.length];
    
        for(int i=0;i<jsonFolder.length;i++){
            
        //Inspecte le dossier ou fichier si il est bien et bien un file
            if(jsonFolder[i].isFile()){

                System.out.println(path +"/"+ jsonFolder[i].getName());
                nameOfJsonFiles[i] = path + "/" + jsonFolder[i].getName();
                
            }   
        } 
        return nameOfJsonFiles;
    }
}

