package es.upm.miw.apiArchitectureUser.api;

import es.upm.miw.apiArchitectureUser.controllers.UserController;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidUserFieldException;
import es.upm.miw.apiArchitectureUser.exceptions.NotFoundUserIdException;
import es.upm.miw.apiArchitectureUser.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.UserListWrapper;

public class UserResource {

	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// POST **/users   body="userName"
	public void createUser(String userName) throws InvalidUserFieldException {
		this.validateField(userName);
		new UserController().createUser(userName);
	}

	private void validateField(String field) throws InvalidUserFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidUserFieldException(field);
		}
	}

	// GET **users/{id}/overage
	public OverageWrapper userOverage(int userId) throws NotFoundUserIdException {
		OverageWrapper overageWrapper = new UserController().userOverage(userId);
		if (overageWrapper == null) {
			throw new NotFoundUserIdException("" + userId);
		} else {
			return overageWrapper;
		}
	}

}
