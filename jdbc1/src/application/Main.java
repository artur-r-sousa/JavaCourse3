package application;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import db.DB;
import db.DbException;
import entities.Worker;


public class Main {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		Set<Worker> set = new HashSet<>();
		String path = "C:\\Users\\artur\\Desktop\\java workspace\\in2.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			//db sheet : Name varchar, AccountBalance double, Email varchar, CCV bigint, Country Varchar, Date Varchar		
			String dataCsv = br.readLine();
			while (dataCsv != null) {
				String[] fields = dataCsv.split(";");
				conn = DB.getConnection();
				st = conn.prepareStatement(
						"INSERT INTO Users "
						+ "(Name, AccountBalance, Email, CCV, Country, Date) "
						+ "VALUES "
						+ "(?, ?, ?, ?, ?, ?)"
						);
				
				st.setString(1, fields[0]);
				st.setDouble(2, Double.parseDouble(fields[1]));
				st.setString(3, fields[2]);
				st.setLong(4, Long.parseLong(fields[3]));
				st.setString(5,  fields[4]);
				st.setString(6, fields[5]);
				
				st.executeUpdate();
				
				dataCsv = br.readLine();
			}
			

		}catch(SQLException e0) {
			throw new DbException(e0.getMessage());
		}catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		finally {
			sc.close();
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
