package entities;

public final class Cnpj extends TaxPayer{
	
	private Integer empNumber;

	public Cnpj() {
		super();
	}
	
	public Cnpj(String name, double annual_i, Integer empNumber) {
		super(name, annual_i);
		this.empNumber = empNumber;
	}

	public Integer getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
	}

	@Override
	public double getTax() {
		double tax = 0;
		if (empNumber <= 10) {
			tax = (super.getAnnual_i() * 0.16);
			return tax;
		} else {
			tax = (super.getAnnual_i() * 0.14);
			return tax;
		}
	}
	
	
}
