package application;


import java.util.Scanner;

import db.DB;




public class Main {

	public static void main(String[] args) {

		DB db = new DB();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the database!");
		int userCheck0 = 0;
		while (userCheck0 != 2) {
			System.out.println("Choose your operation: Check User Info [1], Quit [2]");
			userCheck0 = sc.nextInt();
			
			if (userCheck0 == 1) {
				System.out.print("Please enter User CCV");
				Long userCCV = sc.nextLong();
				System.out.println("Info for " + userCCV + ": " + "\n" + db.getWorkerFromDB(userCCV));
				System.out.println("=========================");
				System.out.print("Update User Account [1], Withdraw[2], Deposit[3], Delete Account [4]");
				int userCheck1 = sc.nextInt();
				switch (userCheck1) {
				case(1):
					sc.nextLine();
					System.out.print("New Name: ");
					String newName = sc.nextLine();
					
					System.out.print("New Email: ");
					String newEmail = sc.nextLine();
					System.out.print("New Country: ");
					String newCountry = sc.nextLine();
					db.updateWorkerName(newName, userCCV);
					db.updateWorkerEmail(newEmail, userCCV);
					db.updateWorkerCountry(newCountry, userCCV);
					
					System.out.println("New Info for User " + userCCV);
					System.out.println(db.getWorkerFromDB(userCCV));
					System.out.println("=========================");
					break;
					
				case(2):
					System.out.print("Withdraw Value: ");
					double withdraw = sc.nextDouble();
					db.withdraw(withdraw, userCCV);
					System.out.println("=========================");
					break;
				case(3):
					System.out.print("Deposit Value: ");
					double deposit = sc.nextDouble();
					db.deposit(deposit, userCCV);
					System.out.println("=========================");
					break;
				case(4):
					System.out.println(db.getWorkerFromDB(userCCV));
					System.out.println("Are you sure you want to delete this account? y/n");
					String userCheckYN = sc.next();
					if (userCheckYN.equals("y")) {
						db.deleteWorkerFromDB(userCCV);
					} else {
						System.out.println("Returning to main screen");
					}
					break;
				}
			}
		
		}

		sc.close();		
		DB.closeConnection();
	}
}
