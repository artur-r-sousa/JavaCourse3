package application;


import entities.Worker;


public class Main {

	public static void main(String[] args) {
		
		Worker wk = new Worker("Artur Sousa", 1.50,"artursousa505@gmail.com", Long.parseLong("5434689050848091"), "United Kingdom","2010-04-17T23:22:40Z");
		wk.sendWorkerToDB(wk);

	}
}
