package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			//prepares the query to be sent to mysql 
			st = conn.prepareStatement(
					"INSERT INTO SELLER "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					//placeholders for the info
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Carl Purple");
			st.setString(2, "carlPurple@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 3);
			
			//confirms the update
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				//retrieves info from db via query 
				ResultSet rs = st.executeQuery("select * from seller");
				while (rs.next()) {
					//tells mysql which column you want
					int id = rs.getInt(1);
					//this could also be "rs.getString/getInt/getDouble("name of the column");
					String name = rs.getString(2);
					System.out.println("Done! id = " + id + ", " + "name = " + name);
					
				}	
			}else {
				System.out.println("No rows Affected ");
			}
			
			st = conn.prepareStatement("DELETE from SELLER where Name = 'Carl Purple' ");
			st.executeUpdate();
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
