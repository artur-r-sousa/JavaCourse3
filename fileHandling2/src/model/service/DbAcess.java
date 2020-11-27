package model.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import model.entities.User;

public class DbAcess {
	
	private User user;
	
	public DbAcess() {
		
	}
	
	public DbAcess(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void sendToDb(Set<User> set) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\artur\\Desktop\\java workspace\\in.txt"));			
			for (Object user : set) {
				bw.write(user.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
