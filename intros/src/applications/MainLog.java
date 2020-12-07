package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class MainLog {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\artur\\Desktop\\java workspace\\intros\\bin\\UserLog.txt";
		Scanner sc = new Scanner(System.in);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>();
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment));
				
				line = br.readLine();
				
			}
			
			System.out.println("Total Users: " + set.size());
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
}
