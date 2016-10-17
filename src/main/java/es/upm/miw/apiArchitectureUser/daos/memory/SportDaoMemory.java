package es.upm.miw.apiArchitectureUser.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureUser.daos.SportDao;
import es.upm.miw.apiArchitectureUser.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer,Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public List<String> findValueByUserId(int userId) {
		List<Sport> sports = this.findAll();
		List<String> sportsValue = new ArrayList<String>();
		for (Sport sport : sports) {
			if (sport.getUser().getId() == userId) {
			    sportsValue.add(sport.getSport());
			}
		}
		return sportsValue;
	}

}