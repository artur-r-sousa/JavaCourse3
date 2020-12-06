package model.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DbAcess0 {
	
	public String getPath() {
		return "C:\\Users\\artur\\Desktop\\java workspace\\in2.csv";
	}
	
	public void sendToDb(List<User> list) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\artur\\Desktop\\java workspace\\fakeBank\\bin\\resources"));
			for (User user : list) {
				bw.write(user.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
