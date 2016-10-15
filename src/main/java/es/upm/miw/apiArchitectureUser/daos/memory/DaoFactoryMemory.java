package es.upm.miw.apiArchitectureUser.daos.memory;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.daos.UserDao;
import es.upm.miw.apiArchitectureUser.daos.SportDao;

public class DaoFactoryMemory extends DaoFactory {

	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
		    userDao = new UserDaoMemory();
		}
		return userDao;
	}

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
		    sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

}
