package es.upm.miw.apiArchitectureUser.api;

import es.upm.miw.apiArchitectureUser.controllers.SportController;
import es.upm.miw.apiArchitectureUser.controllers.UserController;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureUser.exceptions.NotFoundUserIdException;
import es.upm.miw.apiArchitectureUser.wrappers.SportListWrapper;

public class SportResource {

    // POST **/sports body="sport"
    public void createSport(String sport) throws InvalidSportException, NotFoundUserIdException {
        new SportController().createSport(sport);
    }

    // GET **/sport
    public SportListWrapper sportList() {
        return new SportController().sportList();
    }

}
