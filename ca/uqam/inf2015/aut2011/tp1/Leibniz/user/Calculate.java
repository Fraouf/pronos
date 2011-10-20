package user;

public class Calculate {
	
	public static void calculateTotalPayment(User customer){
            
            int numberOfPayment = customer.getDuration()*customer.getPaymentFrequency();
            Amortization amortization[] = new Amortization[numberOfPayment];;
            
            int periode = 0;
            double cumulativeTotalPayment = 0;
            double cumulativeInterestPayment = 0;
            double cumulativeCapitalPayment = 0;
		
            
            for( int i = 0; i < numberOfPayment; i++){
                
                
                Amortization amorti = new Amortization(); 
                
		double totalPayment;
                
                periode++;
                amorti.setPeriode(periode);
                
		
		if(i == 0){
		    amorti.setCapitalBeggining(customer.getAmount());
		}
                else{
                    amorti.setCapitalBeggining(amortization[i-1].getCapitalEnd());
                }
                
                // Calcule TotalPayment
		double interestRates2 = (customer.getInterestRates()/ 100);
		double duration2 = -1 * (customer.getDuration() * 12);
                double valeur1 = 12 / customer.getFrequencyComposition();
		double valeur2 = 1 / valeur1;
		double intRateCapSem = (Math.pow ((1 + (interestRates2 / customer.getFrequencyComposition())),(valeur2))) - 1 ;
		double valeur3 = (1 - ( Math.pow ((1 + intRateCapSem), duration2))) / intRateCapSem;
                
		totalPayment = Math.round((customer.getAmount() / valeur3) * 100);
                totalPayment = totalPayment / 100;
                
		amorti.setTotalPayment(totalPayment);
                customer.setTotalPayment(totalPayment);
                cumulativeTotalPayment = Math.round((cumulativeTotalPayment + totalPayment) * 100);
                cumulativeTotalPayment = cumulativeTotalPayment / 100;
                amorti.setCumulativeTotalPayment(cumulativeTotalPayment);
                
                // Calcule interestPayment
                double interestPayment;
                
		interestPayment = Math.round((amorti.getCapitalBiggining() * intRateCapSem)*100);
                interestPayment = interestPayment/100;
                amorti.setInterestPayment(interestPayment);
                
                cumulativeInterestPayment = Math.round((cumulativeInterestPayment + interestPayment)*100);
                cumulativeInterestPayment = cumulativeInterestPayment / 100;
                amorti.setCumulativeInterestPayment(cumulativeInterestPayment);
                
                
                // Calculer capitalPayment
                double capitalPayment = Math.round((totalPayment - interestPayment) * 100);
                capitalPayment = capitalPayment / 100;
                amorti.setCapitalPayment(capitalPayment);  
                
                // Calculer capitalEnd
                double temp = Math.round((amorti.getCapitalBiggining() - capitalPayment)* 100);
                temp = temp / 100;
                amorti.setCapitalEnd(temp);
                
                cumulativeCapitalPayment = Math.round((cumulativeCapitalPayment + capitalPayment)*100);
                cumulativeCapitalPayment = cumulativeCapitalPayment / 100;
                amorti.setCumulativeCapitalPayment(cumulativeCapitalPayment);
                
                // Créer un objet Amotization
                amortization[i] = amorti;
                
            }
            customer.setAmortization(amortization);
	}
}


