package entities;

public final class Cpf extends TaxPayer{
	
	private double healthExp;
	
	public Cpf() {
		super();
	}
	
		
	public Cpf(String name, double annual_i, double healthExp) {
		super(name, annual_i);
		this.healthExp = healthExp;
	}



	@Override
	public double getTax() {
		double tax = 0;
		if (super.getAnnual_i() <= 20000) {
			tax = (super.getAnnual_i() * 0.15) - (healthExp * 0.5);
			return tax;
		} else {
			tax = (super.getAnnual_i() * 0.25)  - (healthExp * 0.5);
			return tax;
		}
		
	}

}
