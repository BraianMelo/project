
package model.Dao;

import java.util.List;
import model.entities.People;

public interface PeopleDao {
    
    void insert(People people);
    void update(List<People> list);
    void deleteById(Integer id);
    List<People> findAll();
    
}
