package application;


import db.DB;
import entities.Worker;




public class Main {

	public static void main(String[] args) {

		DB db = new DB();
		
		
		db.sendWorkerToDB(new Worker("John Paul Jones", 9.00, "bass@ledZeppelin.com", Long.parseLong("5140806899961234"), "United Kingdom", "2010-04-17T23:22:40Z"));
		db.getWorkerFromDB(5140806899961234L);
		System.out.println(db.getWorkerFromDB(5140806899961234L));
		System.out.println(db.getWorkerFromDB(5140806899966830L));
		db.updateWorkerName("Name", 5140806899966830L);	
		db.updateWorkerEmail("testemail@test.com", 5140806899966830L);
		db.updateWorkerCountry("United Kingdom",  5140806899966830L);
		db.withdraw(0.12, 5140806899966830L);
		db.deposit(1., 5140806899966830L);
		
		
		System.out.println(db.getWorkerFromDB(Long.parseLong("5140806899966830")));
				
		DB.closeConnection();
	}
}
