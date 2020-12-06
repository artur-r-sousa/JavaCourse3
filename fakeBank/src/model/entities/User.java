package model.entities;

import model.services.TaxService;

public class User implements Comparable<User> {

	private String name;
	private Double accountBalance;
	private String email;
	private Long creditCard;
	private String country;
	
	private TaxService tax;
	
	public User(String name, Double accountBalance, String email, Long creditCard, String country, TaxService tax) {

		this.name = name;
		this.accountBalance = accountBalance;
		this.email = email;
		this.creditCard = creditCard;
		this.country = country;
		this.tax = tax;
	}
	
	public TaxService getTax() {
		return tax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString2() {
		return "User Info: " + "\n" + "Name: " + getName() + "\n" + "AccountBalance: " + "$"
				+ String.format("%.2f", getAccountBalance()) + "\n" + "CC Number: " + getCreditCard() + "\n" + "Email: "
				+ getEmail() + "\n" + "Country: " + getCountry() + "\n";
	}

	@Override
	public int compareTo(User other) {

		return creditCard.compareTo(other.getCreditCard());
	}

	@Override
	public String toString() {
		return getName() + "," + String.format("%.2f", getAccountBalance()) + "," + getEmail() + "," + getCreditCard()
				+ "," + getCountry();
	}
}
