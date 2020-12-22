package application;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.Operations;
import model.entities.User;

public class Main {

	public static void main(String[] args){

		try {
			UserDao userDao = DaoFactory.createUserDao();
			Operations op = new Operations();
			
			List<User> list = userDao.findAll();
			MutableDateTime dt2 = new MutableDateTime();	
			InternalClock internalClock = new InternalClock(new LocalTime());
			boolean loop = true;
			while (loop == true) {
				Thread.sleep(999);
				System.out.println(internalClock);
				internalClock = new InternalClock(new DateTime());
				if (internalClock.getDt().getSecondOfMinute() % 10 == 0) {
					for (User user : list) {
						op.simpleInterest(userDao.findById(user.getId()), dt2.toDate());
					}
					
					dt2.addMonths(1);
				}
				
				
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

	}

}