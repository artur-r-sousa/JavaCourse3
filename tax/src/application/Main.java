package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cnpj;
import entities.Cpf;
import entities.TaxPayer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		List<TaxPayer> txPy = new ArrayList<>();
		
		for (int i = 1; i <= n ; i++) {
			System.out.println("Tax payers #" + i + " data");
			
			System.out.print("Individual or Company (i/c): ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name:");
			String name = sc.nextLine();
			System.out.print("Annual Income:");
			double annual_i = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExp = sc.nextDouble();
				txPy.add(new Cpf(name, annual_i, healthExp));
			} else if (ch == 'c') {
				System.out.print("Number of Employees: ");
				int empNumber = sc.nextInt();
				txPy.add(new Cnpj(name, annual_i, empNumber));
			} else { 
				i--;
				System.out.println("Invalid type for Individual or Company");
			}
			
			
		}
		
		System.out.println("---------------------------");
		System.out.println("TAXES PAID");
		double totalTaxes = 0;
		for (TaxPayer t : txPy) {
			System.out.println(t.getName() + ": $" + String.format("%.2f", t.getTax()));
			totalTaxes += t.getTax();
			
		}
		System.out.println("---------------------------");
		System.out.print("TOTAL TAXES: $" + String.format("%.2f", totalTaxes));
		
		sc.close();
	}

}
