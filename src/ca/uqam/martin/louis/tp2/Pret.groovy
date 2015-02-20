package ca.uqam.martin.louis.tp2

import java.math.RoundingMode

import static Monnaie.ZERO

class Pret {
    
    static final PRECISION_INTERET = 12
    
    String id = "Pret 1"
    String description = "Pret 1"
    Monnaie montant = ZERO
    int nombreAnnee = 1
    int frequenceRemboursement = 1
    BigDecimal tauxInteret = 0.01
    int frequenceComposition = 1
    Monnaie versementPeriodique
    BigDecimal tauxInteretPeriodique
    Versement[] versements
    
    def getVersementPeriodique() {
        if ( ! versementPeriodique ) calculer()
        versementPeriodique
    }
    
    def getTauxInteretPeriodique() {
        if ( ! tauxInteretPeriodique ) calculer()
        tauxInteretPeriodique
    }
    
    def getVersements() {
        if ( ! versements ) calculer()
        versements
    }
    
    def setTauxInteret( BigDecimal taux ) {
        tauxInteret = taux.setScale( PRECISION_INTERET, RoundingMode.HALF_UP )
    }
    
    private calculer() {
        versementPeriodique = calculerVersementPeriodique()
        tauxInteretPeriodique = new BigDecimal( calculerTauxPeriodique() ).setScale( PRECISION_INTERET, RoundingMode.HALF_UP )
        versements = calculerVersement()
    }
    
    private Monnaie calculerVersementPeriodique() {
        double tauxPeriodique = calculerTauxPeriodique()
        int nombrePeriode = frequenceRemboursement * nombreAnnee
        montant * ( tauxPeriodique / ( 1 - ( 1 + tauxPeriodique ) ** ( - nombrePeriode ) ) )
        
    }
    
    private double calculerTauxPeriodique() {        
        ( 1 + calculerTauxEffectifAnnuel() ) ** ( 1 / frequenceRemboursement ) - 1
    }
    
    private double calculerTauxEffectifAnnuel() {       
        ( 1 + tauxInteret / frequenceComposition ) ** frequenceComposition - 1
    }
    
    private calculerVersement() {
        int nombrePeriode = frequenceRemboursement * nombreAnnee
        def resultat = new Versement[ nombrePeriode ]
        def capitalDebut = montant
        def versementTotalCumulatif = ZERO
        def versementInteretCumulatif = ZERO
        def versementCapitalCumulatif = ZERO
        ( 1..nombrePeriode ).each { periode ->
            Versement versement = new Versement()
            versement.periode = periode
            versement.capitalDebut = capitalDebut
            versement.versementInteret = capitalDebut * tauxInteretPeriodique
            if ( periode == nombrePeriode ) {
                versement.versementCapital = capitalDebut               
                versement.versementTotal = versement.versementInteret + versement.versementCapital   
            } else {
                versement.versementTotal = versementPeriodique
                versement.versementCapital = versement.versementTotal - versement.versementInteret                              
            }
            versement.capitalFin = capitalDebut - versement.versementCapital
            versement.versementTotalCumulatif = versementTotalCumulatif += versement.versementTotal
            versement.versementInteretCumulatif = versementInteretCumulatif += versement.versementInteret
            versement.versementCapitalCumulatif = versementCapitalCumulatif += versement.versementCapital
            capitalDebut = versement.capitalFin
            resultat[ periode - 1 ] = versement
        }
        resultat
    }
	
    String toString() { """
Pret :
    id = $id 
    description = $description
    montant = $montant
    nombreAnnee = $nombreAnnee 
    frequenceRemboursement = $frequenceRemboursement
    tauxInteret = $tauxInteret
    frequenceComposition = $frequenceComposition
    versementPeriodique = ${getVersementPeriodique()} 
    tauxInteretPeriodique = ${getTauxInteretPeriodique()}
    versements = ${getVersements()}
"""
    }
    
}

