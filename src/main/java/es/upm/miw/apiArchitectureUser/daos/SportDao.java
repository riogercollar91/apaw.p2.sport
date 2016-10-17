package es.upm.miw.apiArchitectureUser.daos;

import java.util.List;

import es.upm.miw.apiArchitectureUser.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer> {
	List<String> findValueByUserId(int UserId);
}
