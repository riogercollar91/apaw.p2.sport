package es.upm.miw.apiArchitectureUser.daos;

import java.util.List;

import es.upm.miw.apiArchitectureUser.entities.Sport;

public interface SportDao extends GenericDao<Sport, Integer> {
	List<Integer> findValueByUserId(int UserId);
}
