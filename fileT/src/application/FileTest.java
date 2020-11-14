package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) {


		File file = new File("C:\\Users\\artur\\Desktop\\in2.txt");
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error opening file - File not Found");
			
		}
		finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
