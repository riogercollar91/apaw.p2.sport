package es.upm.miw.apiArquitectureUser.api;

import es.upm.miw.apiArchitectureUser.controllers.SportController;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureUser.exceptions.NotFoundUserIdException;
import es.upm.miw.apiArchitectureUser.wrappers.SportListWrapper;

public class SportResource {

	// POST **/sports   body="userId:sport"
	public void createSport(int userId, int sport) throws InvalidSportException, NotFoundUserIdException {
		if (sport < 0 || sport > 10) {
			throw new InvalidSportException("" + sport);
		}
		if (!new SportController().createSport(userId, sport)) {
			throw new NotFoundThemeIdException("" + userId);
		}
	}

	// GET **/sport
	public SportListWrapper sportList() {
		return new SportController().sportList();
	}

}
