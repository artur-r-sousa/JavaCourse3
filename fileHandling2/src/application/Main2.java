package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter variable");
		String anal = sc.next();
		Set<String> mySet = new HashSet<>();
		mySet.add("Maria");
		mySet.add("Joao");
		
		
		switch (anal) {
			case "d":
				System.out.println(anal);
				break;
			case "y":
				System.out.println(anal);
				break;
			default:
				System.out.println("Not recognized");
				for (String s : mySet) {
					if (s.equals("Joao")) {
						System.out.println(mySet);
						mySet.remove(anal);
						System.out.println(mySet);
					}
					
				}
				break;
				
		}
		
		sc.close();
	}
}
