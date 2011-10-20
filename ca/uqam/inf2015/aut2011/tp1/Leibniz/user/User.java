package user;


/**
 *
 * @author EmilieGIT
 */
public class User {
	
	private String id;
	private String description;
	private double amount;
	private int duration;
	private int paymentFrequency;
	private float interestRates;
	private int frequencyComposition;
        private double totalPayment;
        private Amortization amortization[];
        
        
        
                
	
	
	public User (String id, String description, double amount, int duration, int paymentFrequency, float interestRates, int frequencyComposition){
		
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.duration = duration;
		this.paymentFrequency = paymentFrequency;
		this.interestRates = interestRates;
		this.frequencyComposition = frequencyComposition;
	}

        public User() {
                
                id = null;
		description = null;
		amount = 0.0;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
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

	public float getInterestRates() {
		return interestRates;
	}

	public void setInterestRates(float interestRates) {
		this.interestRates = interestRates;
	}

	public int getFrequencyComposition() {
		return frequencyComposition;
	}

	public void setFrequencyComposition(int frequencyComposition) {
		this.frequencyComposition = frequencyComposition;
	}
        
        public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
        
        public Amortization[] getAmortization() {
		return amortization;
	}

	public void setAmortization( Amortization[] amortization) {
		this.amortization = amortization;
	}
    
	
}
