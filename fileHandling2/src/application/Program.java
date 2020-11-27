package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.User;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<User> list = new ArrayList<>();
		String path = "C:\\Users\\artur\\Desktop\\java workspace\\in.txt";
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String dataCsv = br.readLine();

			while (i == 0) {
				System.out.println("Choose Operation: ");
				sc.nextLine();
				System.out.println("Search Users(u) // Leave the System (q) // Add User(a)");
				String ch = sc.nextLine();
				if (ch.equals("q")) {
					i = 1;

				} else if (ch.equals("u")) {

					System.out.print("Enter CreditCard number: ");
					Long accNum = sc.nextLong();
					while (dataCsv != null) {
						String[] fields = dataCsv.split(",");
						list.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2],
								Long.parseLong(fields[3]), fields[4]));
						dataCsv = br.readLine();

					}
					for (User user : list) {
						if (user.getCreditCard().equals(accNum))
							System.out.println(user);
					}

				} 
				else if (ch.equals("a")) {
					System.out.println("Enter new user data");
					System.out.print("Name: ");
					String newName = sc.nextLine();
					System.out.print("Account Balance: ");
					double newAccBalance = sc.nextDouble();
					sc.nextLine();
					System.out.print("Email: ");
					String newEmail = sc.nextLine();
					System.out.print("CreditCard number: ");
					Long newCCN = sc.nextLong();
					sc.nextLine();
					System.out.print("Country: ");
					String newCountry = sc.nextLine();
					System.out.println();

					User nUser = new User(newName, newAccBalance, newEmail, newCCN, newCountry);

					if (nUser != null) {
						System.out.println("Confirm User");
						System.out.println(nUser);
						System.out.println("Confirm add? y/n: ");
						String confirm = sc.nextLine();
						if (confirm.equals("y")) {
							nUser.sendToDb(nUser);

						}
					
					
					}
					
				} 
				else if (!ch.equals("q") && !ch.equals("a") && !ch.equals("u")) {
					System.out.println("Wrong option, try again");
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		finally {
			sc.close();
		}
	}
}
