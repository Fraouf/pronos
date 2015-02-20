package ca.uqam.martin.louis.tp2

import java.math.RoundingMode
import java.text.NumberFormat

final class Monnaie {
    
    static final ZERO = new Monnaie( 0 )
    
    final BigDecimal montant
    
    Monnaie( BigDecimal montant ) {
        this.montant = montant.setScale( 2, RoundingMode.HALF_UP )
    }
    
    Monnaie( double montant ) {
        this( new BigDecimal( montant ) )
    }
    
    Monnaie( String montant ) {
        this( new BigDecimal( montant ) )
    }
    
    Monnaie plus( Monnaie monnaie ) {
        new Monnaie( montant + monnaie.montant )
    } 
    
    Monnaie minus( Monnaie monnaie ) {
        new Monnaie( montant - monnaie.montant )
    }
    
    Monnaie multiply( BigDecimal multiplicateur ) {
        new Monnaie( montant * multiplicateur )
    }
    
    Monnaie div( BigDecimal diviseur ) {
        new Monnaie( montant / diviseur )
    }
    
    String format() {
        NumberFormat.currencyInstance.format( montant )
    }
    
    Object asType( Class classe ) {
        if ( classe == BigDecimal ) { return montant }
        if ( classe == String ) { return toString() }
        throw new ClassCastException()
    }
    
    String toString() {
        format()
    }
    
    int compareTo( monnaie ) {
        montant <=> monnaie.montant
    }

    int hashCode() { 
        montant.hashCode() 
    }

    boolean equals( objet ) { 
        objet instanceof Monnaie && montant == objet.montant 
    }
	
}

