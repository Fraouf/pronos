package user;

public class Calculate2 {
	
	public static void calculateTotalPayment(User2 customer){
            
            int numberOfPayment = customer.getDuration()*customer.getPaymentFrequency();
            Amortization amortization[] = new Amortization[numberOfPayment];
            
            int periode = 0;
            long cumulativeTotalPayment = 0;
            long cumulativeInterestPayment = 0;
            long cumulativeCapitalPayment = 0;
		
            
            for( int j = 0; j < numberOfPayment; j++){
                
                Amortization amorti = new Amortization(); 
                
		long totalPayment;
                
                periode++;
                amorti.setPeriode(periode);
                
		
		if(j == 0){
		    amorti.setCapitalBiggining(customer.getAmount());
		}
                else{
                    amorti.setCapitalBiggining(amortization[j-1].getCapitalEnd());
                }
                
                // Calcule TotalPayment
		int interestRates2 = (customer.getInterestRates()/ 100);
		long duration2 = -1 * (customer.getDuration() * 12);
                long valeur1 = 12 / customer.getFrequencyComposition();
		long valeur2 = 1 / valeur1;
		double intRateCapSem = (Math.pow ((1 + (interestRates2 / customer.getFrequencyComposition())),(valeur2))) - 1 ;
		double valeur3 = (1 - ( Math.pow ((1 + intRateCapSem), duration2))) / intRateCapSem;
                
		totalPayment = ((long)(customer.getAmount() / valeur3));
                
                
		amorti.setTotalPayment(totalPayment);
                customer.setTotalPayment(totalPayment);
                cumulativeTotalPayment = cumulativeTotalPayment + totalPayment;
                amorti.setCumulativeTotalPayment(cumulativeTotalPayment);
                
                // Calcule interestPayment
                double interestPayment;
                
		interestPayment = amorti.getCapitalBiggining() * intRateCapSem;
                cumulativeInterestPayment = (long) (cumulativeInterestPayment + interestPayment);
                amorti.setCumulativeInterestPayment(cumulativeInterestPayment);
                amorti.setInterestPayment(interestPayment);
                
                // Calculer capitalPayment
                double capitalPayment = totalPayment - interestPayment;
                amorti.setCapitalPayment(capitalPayment);  
                
                // Calculer capitalEnd
                double temp = amorti.getCapitalBiggining() - capitalPayment;
                amorti.setCapitalEnd(temp);
                
                cumulativeCapitalPayment = (long) (cumulativeCapitalPayment + capitalPayment);
                amorti.setCumulativeCapitalPayment(cumulativeCapitalPayment);
                
                // Créer un objet Amotization
                amortization[j] = amorti;
                
            }
            customer.setAmortization(amortization);
	}
}


