package entities;

public class Worker {

	private String name;
	private Double accountBalance;
	private String email;
	private Long creditCard;
	private String country;
	private String createdIn;

	public Worker() {
		
	}
	public Worker(String name, Double accountBalance, String email, Long creditCard, String country, String createdIn) {

		this.name = name;
		this.accountBalance = accountBalance;
		this.email = email;
		this.creditCard = creditCard;
		this.country = country;
		this.createdIn = createdIn;
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
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
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

	public String getCreatedIn() {
		return createdIn;
	}
	
	public void setCreatedIn(String createdIn) {
		this.createdIn = createdIn;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", accountBalance=" + accountBalance + ", email=" + email + ", creditCard="
				+ creditCard + ", country=" + country + ", createdIn=" + createdIn + "]";
	}
	
}
