package es.upm.miw.apiArchitectureUser.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.entities.User;
import es.upm.miw.apiArchitectureUser.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getId(), user.getName()));
		}
		return userListWrapper;
	}

	public void createUser(String userName) {
		DaoFactory.getFactory().getUserDao().create(new User(userName));
	}

	public OverageWrapper userOverage(int userId) {
		if (DaoFactory.getFactory().getUserDao().read(userId) == null) {
			return null;
		}
		List<String> sportValues = DaoFactory.getFactory().getSportDao().findValueByUserId(userId);
		String total = "";
		for (String value : sportValues) {
			total += value;
		}
		return new OverageWrapper();
	}

}
