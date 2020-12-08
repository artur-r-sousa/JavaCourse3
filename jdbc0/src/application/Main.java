package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			
			st = conn.prepareStatement(
					"INSERT INTO SELLER "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			st.setString(1, "Carl Purple");
			st.setString(2, "carlPurple@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 3);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done. Rows Affected " + rowsAffected);
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
