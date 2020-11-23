package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] msgs = new String[] {"hey", "ho", "lets", "go"};
		Scanner sc = null;
		String path = "C:\\Users\\artur\\Desktop\\out.txt";
		
		try (BufferedWriter bf = new BufferedWriter(new FileWriter(path))) {
			
			for (String msg : msgs) {
				bf.write(msg);
				bf.write(" ");
			}
			
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		

	}

}
