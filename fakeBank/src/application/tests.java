package application;


import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class tests {

	public static void main(String[] args) {
		
		DateTime dt = new DateTime();		
		UserDao userDao = DaoFactory.createUserDao();

		System.out.println("=== Test 1 - insert ===");
		User newUser = new User(null, "Bruce Wayne", 40.0, "brucebruce@gmail.com", 1472583691472583L, "United Kingdom", new Date());
		userDao.insert(newUser);
		System.out.println("Inserted a New Id, id = " + newUser.getId());
		
		System.out.println("\n=== Test 2 - findById ===");
		System.out.println(userDao.findById(322));

		System.out.println("\n=== Test 3 - update ===");
		
		newUser.setName("Martha Wayne");
		newUser.setEmail("MarthaWayne@gmail.com");
		newUser.setCreditCard(7418529637418529L);
		newUser.setCountry("Argentina");
		newUser.setCreatedIn(dt.toDate());
		userDao.update(newUser);
		System.out.println(userDao.findById(newUser.getId()));
		userDao.findById(322).setCountry("United Kingdom");
		
		System.out.println("\n=== Test 4 - withdraw ===");
		userDao.withdraw(10.0, newUser.getCreditCard());
		System.out.println(userDao.findById(newUser.getId()));
		
		System.out.println("\n=== Test 5 - deposit ===");
		userDao.deposit(10.0, newUser.getCreditCard());
		System.out.println(userDao.findById(newUser.getId()));
		
		System.out.println("\n=== Test 6 - deleteById ===");
		userDao.deleteById(newUser.getId());
		
		System.out.println("\n=== Test 7 - findAll ===");
		List<User> list = userDao.findAll();
		for (User a : list) {
			System.out.println(a);
		}
		
		
		
		
	}

}
