/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author k1fryouf
 */
public class Amortization {

	private int periode;
	private double capitalBiggining;
	private double capitalEnd;
	private double totalPayment;
	private double interestPayment;
	private double capitalPayment;
	private double cumulativeTotalPayment;
	private double cumulativeInterestPayment;
	private double cumulativeCapitalPayment;
        
        public Amortization(){
            
        }
        
        public Amortization(int periode, double capitalBiggining, double capitalEnd, double totalPayment, double interestPayment, double capitalPayment, double cumulativeTotalPayment, double cumulativeInterestPayment, double cumulativeCapitalPayment){
            
            this.periode = periode;
            this.capitalBiggining = capitalBiggining;
            this.capitalEnd = capitalEnd;
            this.capitalPayment = capitalPayment;
            this.totalPayment = totalPayment;
            this.interestPayment = interestPayment;
            this.cumulativeCapitalPayment = cumulativeTotalPayment;
            this.cumulativeInterestPayment = cumulativeInterestPayment;
            this.cumulativeTotalPayment = cumulativeTotalPayment;
        }


	public double getCapitalBiggining() {
		return capitalBiggining;
	}
	public void setCapitalBiggining(double capitalBiggining) {
		this.capitalBiggining = capitalBiggining;
	}
	public int getPeriode() {
		return periode;
	}
	public void setPeriode(int periode) {
		this.periode = periode;
	}
	public double getCapitalEnd() {
		return capitalEnd;
	}
	public void setCapitalEnd(double capitalEnd) {   
		this.capitalEnd = capitalEnd;
	}
	public double getInterestPayment() {
		return interestPayment;
	}
	public void setInterestPayment(double interestPayment) {
		this.interestPayment = interestPayment;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public double getCapitalPayment() {
		return capitalPayment;
	}
	public void setCapitalPayment(double capitalPayment) {
		this.capitalPayment = capitalPayment;
	}
	public double getCumulativeTotalPayment() {
		return cumulativeTotalPayment;
	}
	public void setCumulativeTotalPayment(double cumulativeTotalPayment) {
		this.cumulativeTotalPayment = cumulativeTotalPayment;
	}
	public double getCumulativeInterestPayment() {
		return cumulativeInterestPayment;
	}
	public void setCumulativeInterestPayment(double cumulativeInterestPayment) {
		this.cumulativeInterestPayment = cumulativeInterestPayment;
	}
	public double getCumulativeCapitalPayment() {
		return cumulativeCapitalPayment;
	}
	public void setCumulativeCapitalPayment(double cumulativeCapitalPayment) {
		this.cumulativeCapitalPayment = cumulativeCapitalPayment;
	}



}
