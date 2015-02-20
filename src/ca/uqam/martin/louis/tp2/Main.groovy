package ca.uqam.martin.louis.tp2

import static groovy.io.FileType.*
import groovy.json.JsonBuilder 
import groovy.json.JsonSlurper

class Main {
    
    private static File repertoireIntrantJson
    private static File repertoireExtrantJson
    private static File repertoireExtrantHtml
    
    static void main( String[] args ) {
        long tempsDebut = System.currentTimeMillis()
        println "\nDébut de l'exécution\n"
        
        try {
            
            validerRepertoires( args )
            
            repertoireIntrantJson.eachFileMatch FILES , ~/.+\.(json|JSON)/,  { intrant ->
                println "Fichier en traitement : ${intrant.name}"
                def jsonIntrant = new JsonSlurper().parseText( intrant.text )
                def pret = factoryPret( jsonIntrant )  
                ecrireFichierJson( pret )
            }
            
        } catch( ExceptionCalculateurPret ex ) {
            System.err.println( "L'exécution est interrompue\n${ex.message}" )
        } catch( Exception ex ) {
            ex.printStackTrace( System.err )
        } finally {
            long duree = System.currentTimeMillis() - tempsDebut
            println "\nFin de l'exécution (durée en millesecondes : ${duree})\n\n"
        }
    }
    
    private static validerRepertoires( args ) {
        if ( args.length != 3 ) {
            throw new ExceptionCalculateurPret( """
Trois paramètres doivent être fournis sur la ligne de commande :
    le nom du répertoire des intrants JSON
    le nom du répertoire des extrants JSON
    le nom du répertoire des extrants HTML
""" )
        }
        repertoireIntrantJson = factoryRepertoire( args[ 0 ] )
        repertoireExtrantJson = factoryRepertoire( args[ 1 ] )
        repertoireExtrantHtml = factoryRepertoire( args[ 2 ] )
    }
    
    private static factoryRepertoire( nomRepertoire ) {
        File repertoire = new File( nomRepertoire )
        if ( !repertoire.isDirectory() ) {
            throw new ExceptionCalculateurPret( "${repertoire.name} n'est pas un répertoire existant" )
        }
        repertoire
    }
    
    private static factoryPret( json ) {    
        new Pret( id : json.id, 
                  description: json.description,
                  montant: new Monnaie( json.montant ),
                  nombreAnnee: json.nombreAnnee,
                  frequenceRemboursement: json.frequenceRemboursement,
                  tauxInteret: json.tauxInteret / 100,
                  frequenceComposition: json.frequenceComposition )
    }
    
    private static ecrireFichierJson( pret ) {
        def nomFichier = "${repertoireExtrantJson.name}/${pret.id}.json"
        println nomFichier
        def builder = new JsonBuilder()
        def root = builder {
            id pret.id
            description pret.description
            montant pret.montant as BigDecimal
            nombreAnnee pret.nombreAnnee
            frequenceRemboursement pret.frequenceRemboursement
            tauxInteret pret.tauxInteret
            frequenceComposition pret.frequenceComposition
            versementPeriodique pret.versementPeriodique as BigDecimal
            tauxInteretPeriodique pret.tauxInteretPeriodique
            versements pret.versements.inject( [] ) { liste, versement ->     
                liste += builder { 
                    periode versement.periode
                    capitalDebut versement.capitalDebut as BigDecimal
                    versementTotal versement.versementTotal as BigDecimal
                    versementInteret versement.versementInteret as BigDecimal
                    versementCapital versement.versementCapital as BigDecimal
                    capitalFin versement.capitalFin as BigDecimal
                    versementTotalCumulatif versement.versementTotalCumulatif as BigDecimal
                    versementInteretCumulatif versement.versementInteretCumulatif as BigDecimal
                    versementCapitalCumulatif versement.versementCapitalCumulatif as BigDecimal
                }
            }     
            
        }        
        Writer fichier = new PrintWriter( nomFichier, "UTF-8" )
        fichier.write( builder.toPrettyString() )
        fichier.close();       
    }  
	
}

