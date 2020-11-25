package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.ToDo;

public interface ToDoRepository extends JpaRepository <ToDo, Long> {

    ToDo findToDoById(Long id);


}
