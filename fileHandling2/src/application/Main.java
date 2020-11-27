package application;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.User;
public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		String path = "C:\\Users\\artur\\Desktop\\java workspace\\in.txt";
		Scanner sc = new Scanner(System.in);		
		try (BufferedWriter bw0 = new BufferedWriter(new FileWriter(path))) {
			int i = 1;
			while(i > 0 ) {
				User us = new User("k", 100.00, "email", Long.parseLong("151651645"), "country");
				bw0.write(us.toString());
			}			
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Error" + e.getMessage());
		}finally {
			sc.close();
		}
	}
}
