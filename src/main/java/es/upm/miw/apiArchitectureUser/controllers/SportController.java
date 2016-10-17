package es.upm.miw.apiArchitectureUser.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.entities.Sport;
import es.upm.miw.apiArchitectureUser.entities.User;
import es.upm.miw.apiArchitectureUser.wrappers.SportListWrapper;
import es.upm.miw.apiArchitectureUser.wrappers.SportWrapper;

public class SportController {

    public boolean createSport(String sport) {
        User user = DaoFactory.getFactory().getUserDao().read(1);
        if (user != null) {
            DaoFactory.getFactory().getSportDao().create(new Sport(sport));
            return true;
        } else {
            return false;
        }
    }

    public SportListWrapper sportList() {
        List<Sport> sports = DaoFactory.getFactory().getSportDao().findAll();
        SportListWrapper sportListWrapper = new SportListWrapper();
        for (Sport sport : sports) {
            sportListWrapper.addSportWrapper(new SportWrapper(sport.getUser().getName(), sport.getSport()));
        }
        return sportListWrapper;
    }

}
