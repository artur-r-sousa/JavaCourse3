package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import entities.Worker;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null ) {			
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closePrepStatement(PreparedStatement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
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
		}
	}
	
	public Worker getWorkerFromDB(Long CCV) {
		Worker wk = new Worker();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement("use testjdbc");
			ResultSet rs = st.executeQuery("SELECT * FROM users");
			int i = 0;
			while (rs.next() && i == 0) {
				if(rs.getLong("CCV") == CCV ) {
					wk.setName(rs.getString(2));
					wk.setAccountBalance(rs.getDouble(3));
					wk.setEmail(rs.getString(4));
					wk.setCreditCard(rs.getLong(5));
					wk.setCountry(rs.getString(6));
					wk.setCreatedIn(rs.getString(7));
					i = 1;
				} 
			}			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
				
		return wk;
	}
	
	public void updateWorkerName(String newName, Long ccvToUpdate) {
		Connection conn =  null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE users "
					+ "SET Name = ? "
					+ "WHERE "
					+ "(CCV=?)");
			
			st.setString(1, newName);
			st.setLong(2, ccvToUpdate);

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Done, rows affected: " + rowsAffected);
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		} 
	}
	
	public void updateWorkerEmail(String newEmail, Long ccvToUpdate) {
		Connection conn =  null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE users "
					+ "SET Email = ? "
					+ "WHERE "
					+ "(CCV=?)");
			
			st.setString(1, newEmail);
			st.setLong(2, ccvToUpdate);

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Done, rows affected: " + rowsAffected);
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		} 
	}
	public void updateWorkerCountry(String newCountry, Long ccvToUpdate) {
		Connection conn =  null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE users "
					+ "SET Country = ? "
					+ "WHERE "
					+ "(CCV=?)");
			
			st.setString(1, newCountry);
			st.setLong(2, ccvToUpdate);

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Done, rows affected: " + rowsAffected);
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		} 
	}
	
	
	public void withdraw(double withdraw, Long ccvToUpdate) {
		Connection conn =  null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE users "
					+ "SET AccountBalance = AccountBalance - ? "
					+ "WHERE "
					+ "(CCV=?)");
			
			st.setDouble(1, withdraw);
			st.setLong(2, ccvToUpdate);
			
			
			if (withdraw <= getWorkerFromDB(ccvToUpdate).getAccountBalance()) {
				int rowsAffected = st.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Withdraw Sucessfully! New Balance: $ " + String.format("%.2f", getWorkerFromDB(ccvToUpdate).getAccountBalance()));
				}
			} else {
				System.out.println("Insufficient funds for this Transaction");
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		} 
	}
	
	public void deposit(double deposit, Long ccvToUpdate) {
		Connection conn =  null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"UPDATE users "
					+ "SET AccountBalance = AccountBalance + ? "
					+ "WHERE "
					+ "(CCV=?)");
			
			st.setDouble(1, deposit);
			st.setLong(2, ccvToUpdate);
			

			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Deposit Sucessfully! New Balance: $ " + String.format("%.2f", getWorkerFromDB(ccvToUpdate).getAccountBalance()));
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		} 
	}
	
	public void deleteWorkerFromDB(Long ccvToDelete) {
		Connection conn =  null;
		PreparedStatement st = null;
		Worker wk = getWorkerFromDB(ccvToDelete);
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM users "
					+ "WHERE "
					+ "(CCV=?)");
			
			st.setLong(1, ccvToDelete);

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Done, rows affected: " + rowsAffected +
						"\n User: " + wk.getName() + " removed Sucessfully from DB");
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); 
		} 
	}
}
