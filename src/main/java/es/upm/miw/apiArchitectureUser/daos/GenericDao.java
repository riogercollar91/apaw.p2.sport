package es.upm.miw.apiArchitectureUser.daos;

import java.util.List;

public interface GenericDao<T, ID> {

    void create(T entity);

    T read(ID id);

    void update(T entity);

    void deleteById(ID id);

    List<T> findAll();

    List<String> findValueByUserId(int userId);

}
