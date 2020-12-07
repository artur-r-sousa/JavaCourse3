package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import entities.Product;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.0));
		list.add(new Product("Notebook", 1300.0));
		list.add(new Product("PC", 2900.0));
		list.add(new Product("HD", 200.0));
		list.add(new Product("Keyboard", 70.0));
		list.add(new Product("Mouse", 20.0));

		list.forEach(p -> p.setPrice(p.getPrice() * 1.1));
		
		list.forEach(System.out::println);
	}

}
