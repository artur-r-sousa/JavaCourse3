package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
				while (dataCsv != null) {
					String[] fields = dataCsv.split(",");
					list.add(new User(fields[0], Double.parseDouble(fields[1]), fields[2], Long.parseLong(fields[3]),
							fields[4]));
					dataCsv = br.readLine();
				}
				System.out.println("Choose Operation: ");
				sc.nextLine();
				System.out.println("Search Users(s) // Leave the System (q) // Add User(a) // Delete User(d) // Update Users(u)");
				String ch = sc.next();
				

				switch (ch) {

				case "q":
					i = 1;
					break;

				case "s":
					System.out.print("Enter CreditCard number: ");
					Long accNum = sc.nextLong();
					
					for (User user : list) {
						if (user.getCreditCard().equals(accNum)) {
							System.out.println("User Info: " + "\n" + "Name: " + user.getName() + "\n"
									+ "AccountBalance: " + "$" + String.format("%.2f", user.getAccountBalance()) + "\n"
									+ "CC Number: " + user.getCreditCard() + "\n" + "Email: " + user.getEmail() + "\n"
									+ "Country: " + user.getCountry() + "\n");
						}
					}
					break;

				case "a":
					System.out.println("Enter new user data ");
					sc.nextLine();
					System.out.print("Name: ");
					String newName = sc.nextLine();
					System.out.print("Account Balance: ");
					double newAccBalance = sc.nextDouble();
					System.out.print("Email: ");
					String newEmail = sc.next();
					System.out.print("CreditCard number: ");
					Long newCCN = sc.nextLong();
					sc.nextLine();
					System.out.print("Country: ");
					String newCountry = sc.next();
					System.out.println();

					User nUser = new User(newName, newAccBalance, newEmail, newCCN, newCountry);

					if (nUser != null) {
						System.out.println("Confirm User");
						System.out.println("User Info: " + "\n" + "Name: " + nUser.getName() + "\n" + "AccountBalance: "
								+ "$" + String.format("%.2f", nUser.getAccountBalance()) + "\n" + "CC Number: "
								+ nUser.getCreditCard() + "\n" + "Email: " + nUser.getEmail() + "\n" + "Country: "
								+ nUser.getCountry() + "\n");
						System.out.print("Confirm add? y/n: ");
						String confirm = sc.next();

						if (confirm.equals("y")) {
							list.add(nUser);
							nUser.sendToDb(list);
						}
					}
					break;

				case "d":
					System.out.print("Enter CreditCardNumber for the User you want to remove");
					Long compareMe = sc.nextLong();
					sc.nextLine();
					for (User user : list) {
						if (user.getCreditCard().equals(compareMe)) {
							System.out.println("Confirm User");
							System.out.println("User Info: " + "\n" + "Name: " + user.getName() + "\n"
									+ "AccountBalance: " + "$" + String.format("%.2f", user.getAccountBalance()) + "\n"
									+ "CC Number: " + user.getCreditCard() + "\n" + "Email: " + user.getEmail() + "\n"
									+ "Country: " + user.getCountry() + "\n");
							sc.nextLine();
							System.out.println("Confirm Remove? y/n: ");
							String confirm0 = sc.next();
							if (confirm0.equals("y")) {
								list.remove(user);
								user.sendToDb(list);
								System.out.println("User removed");
								break;
							}
						}
					}

					break;
				case "u":
					System.out.print("Enter CreditCardNumber for the User you want to update: ");
					Long compareMe0 = sc.nextLong();
					for (User user : list) {
						if (user.getCreditCard().equals(compareMe0)) {
							System.out.println("User Info: " + "\n" + "Name: " + user.getName() + "\n"
									+ "AccountBalance: " + "$" + String.format("%.2f", user.getAccountBalance()) + "\n"
									+ "CC Number: " + user.getCreditCard() + "\n" + "Email: " + user.getEmail() + "\n"
									+ "Country: " + user.getCountry() + "\n");
							
							sc.nextLine();
							System.out.print("Enter new value for name: ");
							String nName = sc.next();
							sc.nextLine();
							System.out.print("Enter new value for email: ");
							String nEmail = sc.next();
							System.out.print("Enter new value for CC Number: ");
							Long nCCNum = sc.nextLong();
							System.out.print("Enter new value for Country: ");
							String nCountry = sc.next();
							
							System.out.println("User Info: " + "\n" + "Name: " + nName + "\n"
									+ "CC Number: " + nCCNum + "\n" 
									+ "Email: " + nEmail + "\n"
									+ "Country: " + nCountry + "\n");
							
							System.out.println("Confirm Update? y/n: ");							
							String confirm1 = sc.next();
							if (confirm1.equals("y")) {
								user.setName(nName);
								user.setEmail(nEmail);
								user.setCountry(nCountry);
								user.setCreditCard(nCCNum);
								System.out.println("User Info: " + "\n" + "Name: " + user.getName() + "\n"
										+ "AccountBalance: " + "$" + String.format("%.2f", user.getAccountBalance()) + "\n"
										+ "CC Number: " + user.getCreditCard() + "\n" + "Email: " + user.getEmail() + "\n"
										+ "Country: " + user.getCountry() + "\n");
								user.sendToDb(list);
								break;
							}
						}
					}
					
					break;
				default:
					System.out.println("Wrong option, try again");
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InputMismatchException e0) {
			System.out.println("Invalid character");
		}
		finally {
			sc.close();
		}
	}
}
