package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Worker {

	private String name;
	private Double accountBalance;
	private String email;
	private Long creditCard;
	private String country;
	private String createdIn;

	
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
	
	public void sendWorkerToDB(Worker worker) {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement("INSERT INTO Users " + "(Name, AccountBalance, Email, CCV, Country, Date) VALUES " + "(?, ?, ?, ?, ?, ?)");
			st.setString(1, worker.getName());
			st.setDouble(2, worker.getAccountBalance());
			st.setString(3, worker.getEmail());
			st.setLong(4, worker.getCreditCard());
			st.setString(5, worker.getCountry());
			st.setString(6, worker.getCreatedIn());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeConnection();
		}
	}
	
		
}
