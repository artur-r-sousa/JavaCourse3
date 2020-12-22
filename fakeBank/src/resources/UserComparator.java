package resources;

import java.util.Comparator;

import model.entities.User;

public class UserComparator implements Comparator<User> {

	@Override
	public int compare(User u0, User u1) {

		return u0.getCreditCard().compareTo(u1.getCreditCard());
	}

}
