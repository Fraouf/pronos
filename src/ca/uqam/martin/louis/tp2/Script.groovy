package ca.uqam.martin.louis.tp2

import groovy.json.JsonOutput

def magie = { -> new Monnaie( delegate ) }

BigDecimal.metaClass.getDollars = magie
BigInteger.metaClass.getDollars = magie
Integer.metaClass.getDollars = magie
Long.metaClass.getDollars = magie
String.metaClass.getDollars = magie

// EXEMPLES DE DSL : Domain Specific Language

cinq = 5.dollars

println cinq

deux = 2.0.dollars

println deux

vingt = cinq * 2 + deux * 5 

println vingt

println vingt == 20.dollars


// TEST POUR UN PRET

pret = new Pret( id : "Test 1", 
                 description: "Premier test",
                 montant: 100000.dollars, 
                 nombreAnnee: 25,
                 frequenceRemboursement: 12,
                 tauxInteret: 0.10000000,
                 frequenceComposition: 12 )

println pret

println pret.versements[ 299 ] // le 300ième versement



