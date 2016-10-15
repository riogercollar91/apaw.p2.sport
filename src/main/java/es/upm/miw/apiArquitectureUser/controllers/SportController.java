package es.upm.miw.apiArquitectureUser.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.entities.User;
import es.upm.miw.apiArchitectureUser.entities.Sport;
import es.upm.miw.apiArchitectureUser.wrappers.SportListWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.SportWrapper;

public class SportController {

	public boolean createSport(int sportId, int sport) {
		User user = DaoFactory.getFactory().getUserDao().read(userId);
		if (user != null) {
			DaoFactory.getFactory().getSportDao().create(new Sport(sport, user));
			return true;
		} else {
			return false;
		}
	}

	public SportListWrapper sportList() {
		List<Sport> sports = DaoFactory.getFactory().getSportDao().findAll();
		SportListWrapper sportListWrapper = new SportListWrapper();
		for (Sport sport : sports) {
			sportListWrapper.addSportWrapper(new SportWrapper(sport.getUser().getName(),sport.getValue()));
		}
		return sportListWrapper;
	}

}
