package application;


import db.DB;
import entities.Worker;




public class Main {

	public static void main(String[] args) {

		DB db = new DB();
		
		
		db.sendWorkerToDB(new Worker("John Paul Jones", 9.00, "bass@ledZeppelin.com", Long.parseLong("5140806899961234"), "United Kingdom", "2010-04-17T23:22:40Z"));
		db.getWorkerFromDB(Long.parseLong("5140806899961234"));
		System.out.println(db.getWorkerFromDB(Long.parseLong("5140806899961234")));
		System.out.println(db.getWorkerFromDB(Long.parseLong("5140806899966830")));
		db.updateWorkerName("Name", Long.parseLong("5140806899966830"));	
		db.updateWorkerEmail("testemail@test.com", Long.parseLong("5140806899966830"));
		db.updateWorkerCountry("United Kingdom",  Long.parseLong("5140806899966830"));
		db.withdraw(0.12, Long.parseLong("5140806899966830"));
		db.deposit(1.,  Long.parseLong("5140806899966830"));
		
		
		System.out.println(db.getWorkerFromDB(Long.parseLong("5140806899966830")));
				
		DB.closeConnection();
	}
}
