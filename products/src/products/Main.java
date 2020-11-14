package products;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProducts;
import entities.Product;
import entities.UsedProducts;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		int i = 0;
		char ch;
		
		List<Product> productsList = new ArrayList<>();
		
		do {
			i++;
			System.out.println("Product #" + i + " data: ");
			
			System.out.print("Commom, used or imported (c/u/i)");
			char ch2 = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			
			if (ch2 == 'c') {
				Product prod = new Product(name, price);
				productsList.add(prod);
			}else if (ch2 == 'u') {
				System.out.print("Manufactured Date");
				Date manufacturedDate = sdf.parse(sc.next());
				Product prod = new UsedProducts(name, price, manufacturedDate);
				productsList.add(prod);
				
			}else if(ch2 == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product prod = new ImportedProducts(name, price, customsFee);
				productsList.add(prod);
			}
			
			
			System.out.println("Do u wish to add a product? y/n" );
			ch = sc.next().charAt(0);	
		}	while(ch == 'y');
		
		
		System.out.println("Price Tags: ");
		
		for (Product p : productsList) {
			System.out.println(p.priceTag());
		}
		
		
		
		sc.close();

	}

}
