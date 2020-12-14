package application;


import db.DB;



public class Main {

	public static void main(String[] args) {
		

		DB db = new DB();
		
		System.out.println(db.getWorkerFromDB(Long.parseLong("5442255045321780")));
		
		db.updateWorkerName("Artur Ribeiro", Long.parseLong("5442255045321780"));
		
		System.out.println(db.getWorkerFromDB(Long.parseLong("5442255045321780")));
		
		DB.closeConnection();
	}
}
