package it.cast.service;

import it.cast.dao.LoginDao;
import it.cast.domain.User;

public class LoginService {

	public User login(User user) {
		LoginDao ld = new LoginDao();
		User u = ld.login(user);
		return u;
	}

}
