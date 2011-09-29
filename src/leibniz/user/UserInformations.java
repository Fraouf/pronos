package leibniz.user;

public class UserInformations {
		
		private String id;
		private String description;
		private double amount;
		private int duration;
		private int paymentFrequency;
		private float interestRates;
		private int frequencyComposition;
		
		public UserInformations(){
			
		}
		
		public UserInformations (String id, String description, double amount, int duration, int paymentFrequency, float interestRates, int frequencyComposition){
			
			this.setId(id);
			this.setDescription(description);
			this.setAmount(amount);
			this.setDuration(duration);
			this.setPaymentFrequency(paymentFrequency);
			this.setInterestRates(interestRates);
			this.setFrequencyComposition(frequencyComposition);
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
	    
		
	}
