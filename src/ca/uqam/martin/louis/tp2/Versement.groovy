package ca.uqam.martin.louis.tp2

class Versement {
    
    int periode
    Monnaie capitalDebut
    Monnaie versementTotal
    Monnaie versementInteret
    Monnaie versementCapital
    Monnaie capitalFin
    Monnaie versementTotalCumulatif
    Monnaie versementInteretCumulatif
    Monnaie versementCapitalCumulatif
    
    String toString() { """
Versement :
    periode = $periode 
    capitalDebut = $capitalDebut
    versementTotal = $versementTotal
    versementInteret = $versementInteret 
    versementCapital = $versementCapital
    capitalFin = $capitalFin
    versementTotalCumulatif = $versementTotalCumulatif
    versementInteretCumulatif = $versementInteretCumulatif 
    versementCapitalCumulatif = $versementCapitalCumulatif
"""
    }
	
}

