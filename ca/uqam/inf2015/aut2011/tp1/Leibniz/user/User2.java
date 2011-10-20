package user;


/**
 *
 * @author EmilieGIT
 */
public class User2 {
	
	private String id;
	private String description;
	private long amount;
	private int duration;
	private int paymentFrequency;
	private int interestRates;
	private int frequencyComposition;
        private long totalPayment;
        private Amortization amortization[];
        
        
        
                
	
	
	public User2 (String id, String description, long amount, int duration, int paymentFrequency, int interestRates, int frequencyComposition){
		
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.duration = duration;
		this.paymentFrequency = paymentFrequency;
		this.interestRates = interestRates;
		this.frequencyComposition = frequencyComposition;
	}

        public User2 (){
                
                id = null;
		description = null;
		amount = 0;
		duration = 0;
		paymentFrequency = 0;
		interestRates = 0;
		frequencyComposition = 0;
        
        }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(int paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public int getInterestRates() {
		return interestRates;
	}

	public void setInterestRates(int interestRates) {
		this.interestRates = interestRates;
	}

	public int getFrequencyComposition() {
		return frequencyComposition;
	}

	public void setFrequencyComposition(int frequencyComposition) {
		this.frequencyComposition = frequencyComposition;
	}
        
        public long getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(long totalPayment) {
		this.totalPayment = totalPayment;
	}
        
        public Amortization[] getAmortization() {
		return amortization;
	}

	public void setAmortization( Amortization[] amortization) {
		this.amortization = amortization;
	}
    
	
}
