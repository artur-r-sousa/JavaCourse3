package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import model.entities.DbAcess0;
import model.entities.User;
import model.services.ArgentinaTaxService;
import model.services.CanadaTaxService;
import model.services.NZTaxService;
import model.services.PortugalTaxService;
import model.services.UKTaxService;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		Set<User> set = new HashSet<>();
		DbAcess0 db = new DbAcess0();

		
		try (BufferedReader br = new BufferedReader(new FileReader(db.getPath()))) {
			String dataCsv = br.readLine();
			while (dataCsv != null) {
				String[] fields = dataCsv.split(";");
				switch (fields[4]) {
				case ("Argentina"): 
					
					set.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]), fields[4], new ArgentinaTaxService()));
					dataCsv = br.readLine();
					
				case ("Canada"): 
					
					set.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]), fields[4], new CanadaTaxService()));
					dataCsv = br.readLine();
				
				case ("United Kingdom"): 
					
					set.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]), fields[4], new UKTaxService()));
					dataCsv = br.readLine();
				
				case ("Portugal"): 
					
					set.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]), fields[4], new PortugalTaxService()));
					dataCsv = br.readLine();
				
				case ("New Zealand"): 
					
					set.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]), fields[4], new NZTaxService()));
					dataCsv = br.readLine();
					
				}
				
			}

		} catch (IOException e0) {
			System.out.println("Error: " + e0.getMessage());
			e0.printStackTrace();
		} finally {
			sc.close();
		}
		
	}

}
