package spring.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.dao.Status;
import spring.dao.ToDoDao;
import spring.entity.ToDo;
import spring.repository.ToDoRepository;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ToDoJPA implements ToDoDao {

    private ToDoRepository repository;

    @Autowired
    public ToDoJPA(ToDoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(ToDo toDo) {
        repository.save(toDo);
    }

    @Override
    public List<ToDo> all() {
        return repository.findAll();
    }

    @Override
    public void remove(Long id) {
        all().remove(repository.findToDoById(id));
    }

    @Override
    public ToDo findById(Long id) {
        return repository.findToDoById(id);
    }

    @Override
    public void update(Long id, String title) {
        repository.findToDoById(id).setTitle(title);
    }

    @Override
    public List<ToDo> ofStatus(String statusString) {
      return (statusString == null || statusString.isEmpty()) ? all() : ofStatus(Status.valueOf(statusString.toUpperCase()));
    }

    @Override
    public List<ToDo> ofStatus(Status status) {
        return all().stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
    }

    @Override
    public void removeCompleted() {
        ofStatus(Status.COMPLETE).forEach(t -> all().remove(t.getId()));
    }

    @Override
    public void toggleStatus(Long id, boolean isComplete) {
        ToDo todo = repository.findToDoById(id);
        if (isComplete) {
            todo.setStatus(Status.COMPLETE);
        } else {
            todo.setStatus(Status.ACTIVE);
        }
    }

    @Override
    public void toggleAll(boolean complete) {
        all().forEach(t -> t.setStatus(complete ? Status.COMPLETE : Status.ACTIVE));
    }

}
