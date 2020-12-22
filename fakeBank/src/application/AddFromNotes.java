package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class AddFromNotes {

	public static void main(String[] args) throws ParseException{
		UserDao userDao = DaoFactory.createUserDao();
		
		
		try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\artur\\Desktop\\java workspace\\in0.csv"))) {
			String dataCsv = bf.readLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			while(dataCsv != null) {
				String[] fields = dataCsv.split(";");
				userDao.insert(new User(null, fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]), fields[4], sdf.parse(fields[5])));	
				
				
				dataCsv = bf.readLine();
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}

		
	}
}
