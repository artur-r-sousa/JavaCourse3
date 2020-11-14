package entities;

public final class ImportedProducts extends Product {
	
	private double customsFee;
	
	public ImportedProducts() {
		
	}
	public ImportedProducts(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	public double getCustomsFee() {
		return customsFee;
	}
	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		
		return super.getName() + ",  $" + super.getPrice()  + " (Customs Fee: " + customsFee + ")" ;
		
	}

}
