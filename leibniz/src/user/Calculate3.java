package user;

public class Calculate3 {
	
	public static void calculateTotalPayment(User customer){
            
            int numberOfPayment = customer.getDuration()*customer.getPaymentFrequency();
            Amortization amortization[] = new Amortization[numberOfPayment];
            
            
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
                
		totalPayment = customer.getAmount() / valeur3;
                totalPayment = ArrondiDouble.AroundTwoDecimal(totalPayment);
                
		amorti.setTotalPayment(totalPayment);
                customer.setTotalPayment(totalPayment);
                cumulativeTotalPayment = cumulativeTotalPayment + totalPayment;
                cumulativeTotalPayment = ArrondiDouble.AroundTwoDecimal(cumulativeTotalPayment);
                amorti.setCumulativeTotalPayment(cumulativeTotalPayment);
                
                // Calcule interestPayment
                double interestPayment;
                
		interestPayment = amorti.getCapitalBiggining() * intRateCapSem;
                interestPayment = ArrondiDouble.AroundTwoDecimal(interestPayment);
                amorti.setInterestPayment(interestPayment);
                interestPayment = ArrondiDouble.AroundTwoDecimal(interestPayment);
                
                cumulativeInterestPayment = cumulativeInterestPayment + interestPayment;
                cumulativeInterestPayment = ArrondiDouble.AroundTwoDecimal(cumulativeInterestPayment);
                amorti.setCumulativeInterestPayment(cumulativeInterestPayment);
                
                
                // Calculer capitalPayment
                double capitalPayment = totalPayment - interestPayment;
                capitalPayment = ArrondiDouble.AroundTwoDecimal(capitalPayment);
                amorti.setCapitalPayment(capitalPayment);  
                
                // Calculer capitalEnd
                double temp = amorti.getCapitalBiggining() - capitalPayment;
                temp = ArrondiDouble.AroundTwoDecimal(temp);
                amorti.setCapitalEnd(temp);
                
                cumulativeCapitalPayment = cumulativeCapitalPayment + capitalPayment;
                cumulativeCapitalPayment = ArrondiDouble.AroundTwoDecimal(cumulativeCapitalPayment);
                amorti.setCumulativeCapitalPayment(cumulativeCapitalPayment);
                
                // Créer un objet Amotization
                amortization[i] = amorti;
                
            }
            customer.setAmortization(amortization);
	}
}


