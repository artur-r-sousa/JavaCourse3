package entities;

public abstract class TaxPayer {
	
	private String name;
	private double annual_i;
	
	public TaxPayer() {
		
	}
	
	public TaxPayer(String name, double annual_i) {

		this.name = name;
		this.annual_i = annual_i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnnual_i() {
		return annual_i;
	}

	public void setAnnual_i(double annual_i) {
		this.annual_i = annual_i;
	}
	
	public abstract double getTax();

}
