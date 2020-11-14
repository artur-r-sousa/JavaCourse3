package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of Shapes: ");
		int n = sc.nextInt();
		
		List<Shape> shpList = new ArrayList<>();	
		for(int i = 1; i <= n; i++) {
			System.out.println("Shape #" + i + "Data");

			
			System.out.print("Rectangle or Circle(r/c)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Shape Color:");
			Color color = Color.valueOf(sc.next());
			
					
			
			if (ch == 'r') {
				System.out.print("width:");
				double width = sc.nextDouble();
				System.out.print("height:");
				double height = sc.nextDouble();
				Rectangle rec = new Rectangle(color, width, height);
				shpList.add(rec);
				
			}else if(ch == 'c') {
				System.out.print("radius:");
				double radius = sc.nextDouble();				
				Circle circle = new Circle(color, radius);
				shpList.add(circle);
				
			}
		}
		System.out.println("SHAPES AREAS");
		
		
		for (Shape s : shpList) {
			System.out.println(String.format("%.2f", s.getArea()));
		}
		
		
		sc.close();
		

	}

}
