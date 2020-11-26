package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.dao.ToDoDao;
import spring.entity.ToDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ToDoController {

    private ToDoDao toDoDao;
    private List<ToDo> toDoList = new ArrayList<>();

    @Autowired
    public ToDoController(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    @PostMapping(path = "/addTodo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addToDo(@RequestParam Map<String, String> body){
        ToDo toDo = ToDo.create(body.get("todo-title"));
        toDoDao.add(toDo);
    }

    @GetMapping("/todo/{id}")
    public String getToDoById(@PathVariable String id){
        return toDoDao.findById(Long.parseLong(id)).getTitle();
    }

    @DeleteMapping("/todos/{id}")
    public void removeToDo(@PathVariable String id){
        toDoDao.remove(Long.parseLong(id));
    }

    @DeleteMapping("/todos/completed")
    public void removeCompleted(){
        toDoDao.removeCompleted();
    }

    @PostMapping(value = "/list")
    public List<ToDo> listToDo(@RequestParam String status){
        List<ToDo> todos = toDoDao.ofStatus(status);
        return todos;
    }

    @PutMapping("/todos/toggle_all")
    public void toggleAll(@RequestParam(name = "toggle-all") boolean toggle){
        toDoDao.toggleAll(toggle);
    }

    @PutMapping("/todos/{id}/toggle_status")
    public void toggleStatus(@PathVariable Long id,
                             @RequestParam String status){
        boolean completed = status.equals("true");
        toDoDao.toggleStatus(id, completed);
    }

    @PutMapping("/todos/{id}")
    public void updateToDo(@PathVariable Long id, @RequestParam(name = "todo-title") String title){
        toDoDao.update(id, title);
    }


}
