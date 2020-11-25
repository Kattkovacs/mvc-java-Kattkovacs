package spring.dao;

import spring.entity.ToDo;

import java.util.List;


public interface ToDoDao {

    void add(ToDo toDo);

    List<ToDo> all();

    void remove(Long id);

    ToDo findById(Long id);

    void update(Long id, String title);

    List<ToDo> ofStatus(String status);

    List<ToDo> ofStatus(Status status);

    void removeCompleted();

    void toggleStatus(Long id, boolean isComplete);

    void toggleAll(boolean complete);

}

