package model.Dao;

import java.util.List;
import model.entities.Task;

public interface TaskDao {
    
    void insert(Task task);
    void update(List<Task> list);
    List<Task> findAll();
    void deleteByTittle(String tittle);
    
    
}
