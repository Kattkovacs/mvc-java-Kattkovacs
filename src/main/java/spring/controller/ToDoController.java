package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spring.dao.ToDoDao;

@RestController
public class ToDoController {

    private ToDoDao toDoDao;

    @Autowired
    public ToDoController(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

// Mappings from Basic...


}
