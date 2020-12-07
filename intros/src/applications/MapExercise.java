package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExercise {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		Map<String, Integer> votes = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] field = line.split(",");
				if (!votes.containsKey(field[0])) {
					votes.put(field[0], Integer.parseInt(field[1]));
				} 
				else {
					votes.replace(field[0], votes.get(field[0]) + Integer.parseInt(field[1]));				}
				line = br.readLine();
			}			
			System.out.println(votes);
			
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
