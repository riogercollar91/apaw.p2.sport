package es.upm.miw.apiArchitectureUser.daos.memory;

import java.util.HashMap;

import es.upm.miw.apiArchitectureUser.daos.UserDao;
import es.upm.miw.apiArchitectureUser.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Integer, User>());
    }

    @Override
    protected Integer getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Integer id) {
        entity.setId(id);

    }

}
